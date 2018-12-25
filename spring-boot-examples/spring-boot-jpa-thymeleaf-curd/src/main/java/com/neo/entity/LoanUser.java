package com.neo.entity;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 贷款用户信息
 *
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-07-24 12:56:57
 */
@Entity
@Table(name = "loan_user")
public class LoanUser implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name= "rowId", nullable=false)
    private long id;
    //
    private String name;
    //
    private String telNum;
    //身份证号
    private String idNumber;
    //性别 [1]-男;[2]-女
    private String sex;
    //
    private String city;
    //
    private String location;
    //
    private String email;
    //状态 1:推送；2：已发
    private String status;
    //是否有贷款资质 [1]-是;[2]-否
    private String loanQualification;
    //是否有信用卡 [1]-是;[0]-否
    private String hasCreditCard;
    //信用卡额度
    private BigDecimal credit;
    //拥有信用卡年限
    private BigDecimal creditYears;
    //是否有公积金 [1]-是;[0]-否
    private String hasHousingFund;
    //是否买过保险 [1]-是;[0]-否
    private String hasInsurance;
    //是否有过贷款 [1]-是;[0]-否
    private String hasLoan;
    //是否有房贷 [1]-是;[0]-否
    private String hasMortgage;
    //是否有车贷 [1]-是;[0]-否
    private String hasCarLoan;
    //学历 10    博士及以上; 15    硕士; 20    大学本科; 30    大学专科; 40    中专/中等技校; 50    技术学校; 60    高中/中专; 70    初中及以下; 80    小学; 90    文盲或半文盲; 99    未知
    private String education;
    //出生日期
    private Date birthDate;
    //收入
    private BigDecimal salary;
    //职业 0-公司职员；2-私营业主；4-公务员
    private String profession;
    //发薪方式 0-银行转账发薪；1-通过现金发薪
    private String payOffType;
    //
    private String ip;
    //
    private String os;
    //
    private String model;
    //
    private String phoneNo;
    //备注
    private String remark;
    //记录删除标志 [0]-未删除;[1]-逻辑删除
    private String deletedFlag;
    //记录创建人ID
    private BigDecimal createdBy;
    //记录创建时间
    private Date createdDate;
    //记录最近修改人ID
    private BigDecimal lastUpdBy;
    //记录最近修改日期
    private Date lastUpdDate;
    //记录版本
    private BigDecimal versionNum;
    //记录修改次数
    private BigDecimal modificationNum;

    /**
     * 设置：ROW_ID
     */
    public void setId(long rowId) {
        this.id = id;
    }
    /**
     * 获取：ROW_ID
     */
    public long getId() {
        return id;
    }
    /**
     * 设置：
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * 获取：
     */
    public String getName() {
        return name;
    }
    /**
     * 设置：
     */
    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }
    /**
     * 获取：
     */
    public String getTelNum() {
        return telNum;
    }
    /**
     * 设置：身份证号
     */
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
    /**
     * 获取：身份证号
     */
    public String getIdNumber() {
        return idNumber;
    }
    /**
     * 设置：性别 [1]-男;[2]-女
     */
    public void setSex(String sex) {
        this.sex = sex;
    }
    /**
     * 获取：性别 [1]-男;[2]-女
     */
    public String getSex() {
        return sex;
    }
    /**
     * 设置：
     */
    public void setCity(String city) {
        this.city = city;
    }
    /**
     * 获取：
     */
    public String getCity() {
        return city;
    }
    /**
     * 设置：
     */
    public void setLocation(String location) {
        this.location = location;
    }
    /**
     * 获取：
     */
    public String getLocation() {
        return location;
    }
    /**
     * 设置：
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * 获取：
     */
    public String getEmail() {
        return email;
    }
    /**
     * 设置：状态 1:推送；2：已发
     */
    public void setStatus(String status) {
        this.status = status;
    }
    /**
     * 获取：状态 1:推送；2：已发
     */
    public String getStatus() {
        return status;
    }
    /**
     * 设置：是否有贷款资质 [1]-是;[2]-否
     */
    public void setLoanQualification(String loanQualification) {
        this.loanQualification = loanQualification;
    }
    /**
     * 获取：是否有贷款资质 [1]-是;[2]-否
     */
    public String getLoanQualification() {
        return loanQualification;
    }
    /**
     * 设置：是否有信用卡 [1]-是;[0]-否
     */
    public void setHasCreditCard(String hasCreditCard) {
        this.hasCreditCard = hasCreditCard;
    }
    /**
     * 获取：是否有信用卡 [1]-是;[0]-否
     */
    public String getHasCreditCard() {
        return hasCreditCard;
    }
    /**
     * 设置：信用卡额度
     */
    public void setCredit(BigDecimal credit) {
        this.credit = credit;
    }
    /**
     * 获取：信用卡额度
     */
    public BigDecimal getCredit() {
        return credit;
    }
    /**
     * 设置：拥有信用卡年限
     */
    public void setCreditYears(BigDecimal creditYears) {
        this.creditYears = creditYears;
    }
    /**
     * 获取：拥有信用卡年限
     */
    public BigDecimal getCreditYears() {
        return creditYears;
    }
    /**
     * 设置：是否有公积金 [1]-是;[0]-否
     */
    public void setHasHousingFund(String hasHousingFund) {
        this.hasHousingFund = hasHousingFund;
    }
    /**
     * 获取：是否有公积金 [1]-是;[0]-否
     */
    public String getHasHousingFund() {
        return hasHousingFund;
    }
    /**
     * 设置：是否买过保险 [1]-是;[0]-否
     */
    public void setHasInsurance(String hasInsurance) {
        this.hasInsurance = hasInsurance;
    }
    /**
     * 获取：是否买过保险 [1]-是;[0]-否
     */
    public String getHasInsurance() {
        return hasInsurance;
    }
    /**
     * 设置：是否有过贷款 [1]-是;[0]-否
     */
    public void setHasLoan(String hasLoan) {
        this.hasLoan = hasLoan;
    }
    /**
     * 获取：是否有过贷款 [1]-是;[0]-否
     */
    public String getHasLoan() {
        return hasLoan;
    }
    /**
     * 设置：是否有房贷 [1]-是;[0]-否
     */
    public void setHasMortgage(String hasMortgage) {
        this.hasMortgage = hasMortgage;
    }
    /**
     * 获取：是否有房贷 [1]-是;[0]-否
     */
    public String getHasMortgage() {
        return hasMortgage;
    }
    /**
     * 设置：是否有车贷 [1]-是;[0]-否
     */
    public void setHasCarLoan(String hasCarLoan) {
        this.hasCarLoan = hasCarLoan;
    }
    /**
     * 获取：是否有车贷 [1]-是;[0]-否
     */
    public String getHasCarLoan() {
        return hasCarLoan;
    }
    /**
     * 设置：学历 10    博士及以上; 15    硕士; 20    大学本科; 30    大学专科; 40    中专/中等技校; 50    技术学校; 60    高中/中专; 70    初中及以下; 80    小学; 90    文盲或半文盲; 99    未知
     */
    public void setEducation(String education) {
        this.education = education;
    }
    /**
     * 获取：学历 10    博士及以上; 15    硕士; 20    大学本科; 30    大学专科; 40    中专/中等技校; 50    技术学校; 60    高中/中专; 70    初中及以下; 80    小学; 90    文盲或半文盲; 99    未知
     */
    public String getEducation() {
        return education;
    }
    /**
     * 设置：出生日期
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    /**
     * 获取：出生日期
     */
    public Date getBirthDate() {
        return birthDate;
    }
    /**
     * 设置：收入
     */
    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
    /**
     * 获取：收入
     */
    public BigDecimal getSalary() {
        return salary;
    }
    /**
     * 设置：职业 0-公司职员；2-私营业主；4-公务员
     */
    public void setProfession(String profession) {
        this.profession = profession;
    }
    /**
     * 获取：职业 0-公司职员；2-私营业主；4-公务员
     */
    public String getProfession() {
        return profession;
    }
    /**
     * 设置：发薪方式 0-银行转账发薪；1-通过现金发薪
     */
    public void setPayOffType(String payOffType) {
        this.payOffType = payOffType;
    }
    /**
     * 获取：发薪方式 0-银行转账发薪；1-通过现金发薪
     */
    public String getPayOffType() {
        return payOffType;
    }
    /**
     * 设置：
     */
    public void setIp(String ip) {
        this.ip = ip;
    }
    /**
     * 获取：
     */
    public String getIp() {
        return ip;
    }
    /**
     * 设置：
     */
    public void setOs(String os) {
        this.os = os;
    }
    /**
     * 获取：
     */
    public String getOs() {
        return os;
    }
    /**
     * 设置：
     */
    public void setModel(String model) {
        this.model = model;
    }
    /**
     * 获取：
     */
    public String getModel() {
        return model;
    }
    /**
     * 设置：
     */
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    /**
     * 获取：
     */
    public String getPhoneNo() {
        return phoneNo;
    }
    /**
     * 设置：备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
    /**
     * 获取：备注
     */
    public String getRemark() {
        return remark;
    }
    /**
     * 设置：记录删除标志 [0]-未删除;[1]-逻辑删除
     */
    public void setDeletedFlag(String deletedFlag) {
        this.deletedFlag = deletedFlag;
    }
    /**
     * 获取：记录删除标志 [0]-未删除;[1]-逻辑删除
     */
    public String getDeletedFlag() {
        return deletedFlag;
    }
    /**
     * 设置：记录创建人ID
     */
    public void setCreatedBy(BigDecimal createdBy) {
        this.createdBy = createdBy;
    }
    /**
     * 获取：记录创建人ID
     */
    public BigDecimal getCreatedBy() {
        return createdBy;
    }
    /**
     * 设置：记录创建时间
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    /**
     * 获取：记录创建时间
     */
    public Date getCreatedDate() {
        return createdDate;
    }
    /**
     * 设置：记录最近修改人ID
     */
    public void setLastUpdBy(BigDecimal lastUpdBy) {
        this.lastUpdBy = lastUpdBy;
    }
    /**
     * 获取：记录最近修改人ID
     */
    public BigDecimal getLastUpdBy() {
        return lastUpdBy;
    }
    /**
     * 设置：记录最近修改日期
     */
    public void setLastUpdDate(Date lastUpdDate) {
        this.lastUpdDate = lastUpdDate;
    }
    /**
     * 获取：记录最近修改日期
     */
    public Date getLastUpdDate() {
        return lastUpdDate;
    }
    /**
     * 设置：记录版本
     */
    public void setVersionNum(BigDecimal versionNum) {
        this.versionNum = versionNum;
    }
    /**
     * 获取：记录版本
     */
    public BigDecimal getVersionNum() {
        return versionNum;
    }
    /**
     * 设置：记录修改次数
     */
    public void setModificationNum(BigDecimal modificationNum) {
        this.modificationNum = modificationNum;
    }
    /**
     * 获取：记录修改次数
     */
    public BigDecimal getModificationNum() {
        return modificationNum;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
