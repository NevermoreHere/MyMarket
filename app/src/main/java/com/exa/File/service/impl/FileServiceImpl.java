package com.exa.File.service.impl;

import com.exa.entity.File;
import com.exa.mapper.FileMapper;
import com.exa.File.service.IFileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author leo
 * @since 2021-11-09
 */
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements IFileService {

}
