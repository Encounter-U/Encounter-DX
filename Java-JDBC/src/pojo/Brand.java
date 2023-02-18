package pojo;

/**
 * 品牌
 * 使用int会有默认值0，对业务有影响，Integer也有默认值，但默认值为null
 *
 * alt+鼠标左键：整列编辑
 *
 * Fn+Alt+Insert快捷键
 *
 * 在实体类中，基本数据类型建议使用其对应的包装类型
 *
 */
public class Brand
    {
        private Integer id           ;
        // id 主键
        private String brandName   ;
        // 品牌名
        private String companyName ;
        // 企业名
        private Integer ordered      ;
        // 排序字段
        private String description  ;
        // 描述信息
        private Integer status       ;
        //使用int会有默认值0，对业务有影响，Integer也有默认值，但默认值为null
        // 状态：0：禁用  1：启用

        public Integer getId()
            {
                return id;
            }

        public void setId(int id)
            {
                this.id = id;
            }

        public String getBrandName()
            {
                return brandName;
            }

        public void setBrandName(String brandName)
            {
                this.brandName = brandName;
            }

        public String getCompanyName()
            {
                return companyName;
            }

        public void setCompanyName(String companyName)
            {
                this.companyName = companyName;
            }

        public Integer getOrdered()
            {
                return ordered;
            }

        public void setOrdered(Integer ordered)
            {
                this.ordered = ordered;
            }

        public String getDescription()
            {
                return description;
            }

        public void setDescription(String description)
            {
                this.description = description;
            }

        public Integer getStatus()
            {
                return status;
            }

        public void setStatus(Integer status)
            {
                this.status = status;
            }

        @Override
        public String toString()
            {
                return "Brand{" +
                        "id=" + id +
                        ", brandName='" + brandName + '\'' +
                        ", companyName='" + companyName + '\'' +
                        ", ordered=" + ordered +
                        ", description='" + description + '\'' +
                        ", status=" + status +
                        '}';
            }

    }
