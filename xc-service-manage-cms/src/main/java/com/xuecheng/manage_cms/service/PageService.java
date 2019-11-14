package com.xuecheng.manage_cms.service;

import com.xuecheng.framework.domain.cms.CmsConfig;
import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.domain.cms.response.CmsPageResult;
import com.xuecheng.framework.domain.cms.response.CmsPostPageResult;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.ResponseResult;

public interface PageService {
    /**
     *分页查询+条件查询
     * @param page
     * @param size
     * @param queryPageRequest
     * @return
     */
    public QueryResponseResult findList(int page,int size, QueryPageRequest queryPageRequest);

    /**
     * 新增页面
     * @param cmsPage
     * @return
     */
    public CmsPageResult add(CmsPage cmsPage);

    /**
     * 根据id查询页面
     * @param id
     * @return
     */
    public CmsPage getById(String id);

    /**
     * 更新页面信息
     * @param id
     * @param cmsPage
     * @return
     */
    public CmsPageResult update(String id,CmsPage cmsPage);

    /**
     * 根据id删除页面
     * @param id
     * @return
     */
    public ResponseResult delete(String id);

    /**
     * 根据id查询配置管理信息
     * @param id
     * @return
     */
    public CmsConfig getConfigById(String id);

    /**
     * 页面静态化方法
     *
     * 静态化程序获取页面的DataUrl
     * 静态化程序远程请求DataUrl
     * 静态化程序获取页面的模板信息
     * 执行页面静态化
     * @param pageId
     * @return
     */
    public String getPageHtml(String pageId);

    /**
     * 页面发布
     * @param pageId
     * @return
     */
    public ResponseResult post(String pageId);

    CmsPageResult save(CmsPage cmsPage);

    /**
     * 一键发布页面
     * @param cmsPage
     * @return
     */
    CmsPostPageResult postPageQuick(CmsPage cmsPage);
}
