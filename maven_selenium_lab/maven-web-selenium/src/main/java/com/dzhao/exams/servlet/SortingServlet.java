package com.dzhao.exams.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Home on 5/08/2015.
 */
public class SortingServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String numbers = (String)req.getParameter("numbers");
        Integer[] sortingList = convert(numbers);
        Integer[] sortedList = bubbleSort(sortingList);
        //req.setAttribute("sorted_numbers", sortedList);
        //req.getRequestDispatcher("/index.jsp").forward(req, resp);

        StringBuilder builder = new StringBuilder();
        for (int i=0; i<sortedList.length; i++){
            builder.append(sortedList[i] + "  ");
        }
        resp.getWriter().write( "Bubble Sorted List: " + builder.toString() );
        resp.getWriter().flush();
        resp.getWriter().close();
    }

    private Integer[] convert(String numbers){
        List<String> list = new ArrayList<String>(Arrays.asList(numbers.split(",")));
        Integer[] numberList = new Integer[list.size()];
        for(int i = 0; i<list.size(); i++){
            numberList[i] = Integer.valueOf(list.get(i));
        }
        return numberList;
    }

    private Integer[] bubbleSort(Integer[] sortingList){
        int n = sortingList.length;
        int temp;
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(sortingList[j-1] > sortingList[j]){
                    temp = sortingList[j-1];
                    sortingList[j-1] = sortingList[j];
                    sortingList[j] = temp;
                }
            }
        }
        return sortingList;
    }
}
