package com.xuecheng.search.service;

import com.xuecheng.framework.domain.course.CoursePub;
import com.xuecheng.framework.domain.search.CourseSearchParam;
import com.xuecheng.framework.model.response.QueryResponseResult;

/**
 * @Date 2019/10/24 13:36
 */

public interface EsCourseService {
    QueryResponseResult<CoursePub> list(int page, int size, CourseSearchParam courseSearchParam);
}
