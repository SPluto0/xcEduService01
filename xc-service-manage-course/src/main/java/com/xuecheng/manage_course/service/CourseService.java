package com.xuecheng.manage_course.service;

import com.xuecheng.framework.domain.course.CoursePic;
import com.xuecheng.framework.domain.course.Teachplan;
import com.xuecheng.framework.domain.course.ext.CourseView;
import com.xuecheng.framework.domain.course.ext.TeachplanNode;
import com.xuecheng.framework.domain.course.response.CoursePublishResult;
import com.xuecheng.framework.model.response.ResponseResult;

/**
 * @Date 2019/9/21 16:11
 */
public interface CourseService {

    /**
     * 查询课程计划
     * @param courseId
     * @return
     */
    public TeachplanNode  findTeachplanList(String courseId);

    /**
     * 添加课程计划
     * @param teachplan
     * @return
     */
    ResponseResult addTeachplan(Teachplan teachplan);

    /**
     * 向课程管理数据添加课程与图片的关联信息
     * @param courseId
     * @param pic
     * @return
     */
    ResponseResult addCoursePic(String courseId, String pic);

    /**
     * 查询课程图片
     * @param courseId
     * @return
     */
    CoursePic findCoursePic(String courseId);

    /**
     * 删除课程图片
     * @param courseId
     * @return
     */
    ResponseResult deleteCoursePic(String courseId);

    /**
     * 查询课程视图，包括基本信息、图片、营销、课程计划
     * @param id
     * @return
     */
    CourseView getCoruseView(String id);

    /**
     * 课程预览
     * @param id
     * @return
     */
    CoursePublishResult preview(String id);

    /**
     * 课程发布
     * @param id
     * @return
     */
    CoursePublishResult publish(String id);
}
