package LeetCode;

import java.util.*;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates
 * that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 *
 * Example 1:
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 *
 * Example 2:
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0,
 * and to take course 0 you should also have finished course 1. So it is impossible.
 *
 *
 * Constraints:
 * 1 <= numCourses <= 105
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * All the pairs prerequisites[i] are unique.
 */
public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        //do top sort, use numCourses to prefill inDegree

        if(prerequisites == null || prerequisites.length == 0) return true;

        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for(int course = 0; course < numCourses; course++) inDegree.put(course, 0);

        //now fill adj list and inDegrees

        for(int[] coursePair : prerequisites){

            int from = coursePair[1];
            int to = coursePair[0];

            if(!adj.containsKey(from))
                adj.put(from, new ArrayList<>());

            adj.get(from).add(to);

            inDegree.compute(to , (k , v)-> v == null ? 1 : v + 1);
        }

        //find the 0 inDegree nodes

        Queue<Integer> toVisit = new LinkedList<>();

        for(int course = 0; course < numCourses; course++){

            if(inDegree.get(course) > 0) continue;

            toVisit.offer(course);
        }

        if(toVisit.isEmpty()) return false;

        //process all vertices in the toVisit q, and decrees the edges
        int coursesTaken = 0;

        while(!toVisit.isEmpty()){
            int vertex = toVisit.poll();
            coursesTaken++;
            List<Integer> edges = adj.get(vertex);

            if(edges == null) continue;
            for(Integer courseToTake : edges){
                inDegree.compute(courseToTake , (k , v)-> v == null ? 0 : v -1);
                if(inDegree.get(courseToTake) == 0)
                    toVisit.offer(courseToTake);
            }
        }
        return coursesTaken == numCourses;
    }

    public static void main (String[] args) {
        System.out.println(canFinish(2 , new int[][]{{1 , 0} , {0 , 1}}));
    }
}
