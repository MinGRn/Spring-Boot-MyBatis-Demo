package ${basePackage}.service.impl;

import ${basePackage}.mapper.${domainNameUpperCamel}Mapper;
import ${basePackage}.domain.${domainNameUpperCamel};
import ${basePackage}.service.${domainNameUpperCamel}Service;
import ${basePackage}.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * ${description}-ServiceImpl类
 * @author: ${author} on ${date}
 * @version: 3.0.0
 */
@Service
@Transactional
public class ${domainNameUpperCamel}ServiceImpl extends AbstractService<${domainNameUpperCamel}> implements ${domainNameUpperCamel}Service {
    @Resource
    private ${domainNameUpperCamel}Mapper ${domainNameLowerCamel}Mapper;

}
