package com.xuecheng.manage_cms_client.service;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.CmsSite;

import java.io.InputStream;

/**
 * @Date 2019/9/19 11:05
 */
public interface PageService {

    //将页面html保存到页面物理路径
    public void savePageToServerPath(String pageId);

    //根据文件id从GridFS中查询文件内容
    public InputStream getFileById(String fileId);

    //根据页面id查询页面信息
    public CmsPage findCmsPageById(String pageId);

    //根据站点id查询站点信息
    public CmsSite findCmsSiteById(String siteId);
}
