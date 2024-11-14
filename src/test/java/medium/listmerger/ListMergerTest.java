package medium.listmerger;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ListMergerTest {

    ListMerger listMerger = new ListMerger();

    @Test
    public void test(){
        int[][] merge = listMerger.merge(new int[][]{{1, 4}, {0, 1}});
    }
}