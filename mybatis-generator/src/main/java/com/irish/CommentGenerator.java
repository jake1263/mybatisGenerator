package com.irish;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.internal.DefaultCommentGenerator;

/**
 * 
 * 重写了MybatisGenerator的注释方法，去掉了@mbg 注解 （该注解是防止第二次生成代码时把旧的覆盖）
 * 只是在model中根据数据库字段名称生成属性注释
 *
 */
public class CommentGenerator extends DefaultCommentGenerator {
 
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        field.addJavaDocLine("/**");  
        StringBuilder sb = new StringBuilder("");  
        sb.append(" *");  
        if(introspectedColumn.getRemarks() != null && !introspectedColumn.getRemarks().equals("")) {
        	sb.append("*"+introspectedColumn.getRemarks());  
        }else {
        	sb.append("");
        }
        field.addJavaDocLine(sb.toString());  
        field.addJavaDocLine(" */");  
    }
}