package com.cn.test;

import com.cn.test.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbggenerated
     */
    @Delete({
        "delete from sys_user",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbggenerated
     */
    @Insert({
        "insert into sys_user (id, company_id, ",
        "office_id, login_name, ",
        "password, no, name, ",
        "email, phone, mobile, ",
        "user_type, photo, login_ip, ",
        "login_date, login_flag, ",
        "create_by, create_date, ",
        "update_by, update_date, ",
        "remarks, del_flag)",
        "values (#{id,jdbcType=VARCHAR}, #{companyId,jdbcType=VARCHAR}, ",
        "#{officeId,jdbcType=VARCHAR}, #{loginName,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{no,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{email,jdbcType=VARCHAR}, #{phone,jdbcType=VARCHAR}, #{mobile,jdbcType=VARCHAR}, ",
        "#{userType,jdbcType=CHAR}, #{photo,jdbcType=VARCHAR}, #{loginIp,jdbcType=VARCHAR}, ",
        "#{loginDate,jdbcType=TIMESTAMP}, #{loginFlag,jdbcType=VARCHAR}, ",
        "#{createBy,jdbcType=VARCHAR}, #{createDate,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=VARCHAR}, #{updateDate,jdbcType=TIMESTAMP}, ",
        "#{remarks,jdbcType=VARCHAR}, #{delFlag,jdbcType=CHAR})"
    })
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbggenerated
     */
    int insertSelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbggenerated
     */
    @Select({
        "select",
        "id, company_id, office_id, login_name, password, no, name, email, phone, mobile, ",
        "user_type, photo, login_ip, login_date, login_flag, create_by, create_date, ",
        "update_by, update_date, remarks, del_flag",
        "from sys_user",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @ResultMap("BaseResultMap")
    User selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbggenerated
     */
    @Update({
        "update sys_user",
        "set company_id = #{companyId,jdbcType=VARCHAR},",
          "office_id = #{officeId,jdbcType=VARCHAR},",
          "login_name = #{loginName,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "no = #{no,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "mobile = #{mobile,jdbcType=VARCHAR},",
          "user_type = #{userType,jdbcType=CHAR},",
          "photo = #{photo,jdbcType=VARCHAR},",
          "login_ip = #{loginIp,jdbcType=VARCHAR},",
          "login_date = #{loginDate,jdbcType=TIMESTAMP},",
          "login_flag = #{loginFlag,jdbcType=VARCHAR},",
          "create_by = #{createBy,jdbcType=VARCHAR},",
          "create_date = #{createDate,jdbcType=TIMESTAMP},",
          "update_by = #{updateBy,jdbcType=VARCHAR},",
          "update_date = #{updateDate,jdbcType=TIMESTAMP},",
          "remarks = #{remarks,jdbcType=VARCHAR},",
          "del_flag = #{delFlag,jdbcType=CHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(User record);
}