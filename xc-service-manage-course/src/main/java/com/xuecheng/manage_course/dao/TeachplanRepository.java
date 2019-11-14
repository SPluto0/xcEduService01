package com.xuecheng.manage_course.dao;

import com.xuecheng.framework.domain.course.CourseBase;
import com.xuecheng.framework.domain.course.Teachplan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Administrator.
 */
public interface TeachplanRepository extends JpaRepository<Teachplan,String> {

    /**
     * 根据课程id和parentid查询Teachplan
     * select * from teachplan a WHERE a.courseid ='4028e581617f945f01617f9dabc40000' and a.parentid ='0'
     */
    public List<Teachplan> findByCourseidAndParentid(String courseid,String parentid);
}
