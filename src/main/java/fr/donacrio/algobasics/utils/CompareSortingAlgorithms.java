package fr.donacrio.algobasics.utils;

import com.github.plot.Plot;
import fr.donacrio.algobasics.sort.BubbleSort;
import fr.donacrio.algobasics.sort.BubbleSortImproved;
import fr.donacrio.algobasics.sort.MergeSort;
import fr.donacrio.algobasics.sort.Sort;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CompareSortingAlgorithms {

    public void compare(List<Sort> sorts) {
        compare(sorts, 1000, 1, "default");
    }

    public void compare(List<Sort> sorts, int max, int step, String filename) {
        HashMap<Sort, List<Long>> results = new HashMap<>();
        for(Sort sort : sorts) {
            results.put(sort, new ArrayList<>());
        }
        for(int i = 0; i < max; i += step) {
            int[] arr = Utils.randomIntArray(i);
            for(Sort sort : sorts) {
                long start = System.nanoTime();
                sort.sort(arr);
                long finish = System.nanoTime();
                List<Long> sortResults = results.get(sort);
                sortResults.add(finish - start);
            }
        }
        plotResults(results, step, filename);
    }

    private void plotResults(HashMap<Sort, List<Long>> results, int step, String filename) {
        Plot plot = Plot.plot(
                Plot.plotOpts()
                .title("Sorting results")
                .legend(Plot.LegendFormat.BOTTOM))
                .xAxis("n", Plot.axisOpts())
                .yAxis("T(ns)", Plot.axisOpts());
        Color[] colors = Utils.getColors(results.keySet().size());
        int iColor = 0;
        for(Sort sort : results.keySet()) {
            List<Long> sortResults = results.get(sort);
            Plot.Data data = Plot.data();
            for(int i = 0; i < sortResults.size(); i++) {
                data.xy(i * step, sortResults.get(i));
            }
            plot.series(
                    sort.getName(),
                    data,
                    Plot.seriesOpts()
                        .marker(Plot.Marker.CIRCLE)
                            .markerColor(colors[iColor++])
                        .line(Plot.Line.NONE)
            );
        }
        try {
            plot.save("plots/" + filename, "png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<Sort> sorts = new ArrayList<>();
        sorts.add(new BubbleSort());
        sorts.add(new BubbleSortImproved());
        sorts.add(new MergeSort());
        CompareSortingAlgorithms comparator = new CompareSortingAlgorithms();
        comparator.compare(sorts, 10000, 100, "test");
    }
}
