package com.ktcd.malc.kt_ma_lc.responseparam;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/7/14.
 */

public class IdGetInfoResponse implements Serializable  {
    /**
     * cpId : 287
     * cpName : 李专生
     * cpMobile : 13543236094
     * cpLoginName : lzx
     * cpLoginPwd : e10adc3949ba59abbe56e057f20f883e
     * department : {"id":151,"text":"林业局护林员队伍","bdmLevel":null,"createTime":1497954142505,"updateTime":1497954142505,"bdmId":151,"bdmCode":"08","bdmName":"林业局护林员队伍","bdmType":"DD_FORESTRY","bdmLongitude":116.089314,"bdmLatitude":24.272609,"department":{"id":147,"text":"林业局","bdmLevel":null,"createTime":1497953847865,"updateTime":1497953847865,"bdmId":147,"bdmCode":"04","bdmName":"林业局","bdmType":"DD_FORESTRY","bdmLongitude":116.089314,"bdmLatitude":24.272609,"department":{"id":145,"text":"梅县区","bdmLevel":null,"createTime":1497953735041,"updateTime":1497953735041,"bdmId":145,"bdmCode":"02","bdmName":"梅县区","bdmType":"DD_PUBLIC_SECURITY","bdmLongitude":116.088894,"bdmLatitude":24.272185,"department":{"id":99999,"text":"梅州市","bdmLevel":1,"createTime":null,"updateTime":null,"bdmId":99999,"bdmCode":"01","bdmName":"梅州市","bdmType":null,"bdmLongitude":116.129223,"bdmLatitude":24.294547,"department":null}}}}
     */

    private int cpId;
    private String cpName;
    private String cpMobile;
    private String cpLoginName;
    private String cpLoginPwd;
    private DepartmentBeanXXX department;

    public int getCpId() {
        return cpId;
    }

    public void setCpId(int cpId) {
        this.cpId = cpId;
    }

    public String getCpName() {
        return cpName;
    }

    public void setCpName(String cpName) {
        this.cpName = cpName;
    }

    public String getCpMobile() {
        return cpMobile;
    }

    public void setCpMobile(String cpMobile) {
        this.cpMobile = cpMobile;
    }

    public String getCpLoginName() {
        return cpLoginName;
    }

    public void setCpLoginName(String cpLoginName) {
        this.cpLoginName = cpLoginName;
    }

    public String getCpLoginPwd() {
        return cpLoginPwd;
    }

    public void setCpLoginPwd(String cpLoginPwd) {
        this.cpLoginPwd = cpLoginPwd;
    }

    public DepartmentBeanXXX getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentBeanXXX department) {
        this.department = department;
    }

    public static class DepartmentBeanXXX {
        /**
         * id : 151
         * text : 林业局护林员队伍
         * bdmLevel : null
         * createTime : 1497954142505
         * updateTime : 1497954142505
         * bdmId : 151
         * bdmCode : 08
         * bdmName : 林业局护林员队伍
         * bdmType : DD_FORESTRY
         * bdmLongitude : 116.089314
         * bdmLatitude : 24.272609
         * department : {"id":147,"text":"林业局","bdmLevel":null,"createTime":1497953847865,"updateTime":1497953847865,"bdmId":147,"bdmCode":"04","bdmName":"林业局","bdmType":"DD_FORESTRY","bdmLongitude":116.089314,"bdmLatitude":24.272609,"department":{"id":145,"text":"梅县区","bdmLevel":null,"createTime":1497953735041,"updateTime":1497953735041,"bdmId":145,"bdmCode":"02","bdmName":"梅县区","bdmType":"DD_PUBLIC_SECURITY","bdmLongitude":116.088894,"bdmLatitude":24.272185,"department":{"id":99999,"text":"梅州市","bdmLevel":1,"createTime":null,"updateTime":null,"bdmId":99999,"bdmCode":"01","bdmName":"梅州市","bdmType":null,"bdmLongitude":116.129223,"bdmLatitude":24.294547,"department":null}}}
         */

        private int id;
        private String text;
        private Object bdmLevel;
        private long createTime;
        private long updateTime;
        private int bdmId;
        private String bdmCode;
        private String bdmName;
        private String bdmType;
        private double bdmLongitude;
        private double bdmLatitude;
        private DepartmentBeanXX department;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public Object getBdmLevel() {
            return bdmLevel;
        }

        public void setBdmLevel(Object bdmLevel) {
            this.bdmLevel = bdmLevel;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(long updateTime) {
            this.updateTime = updateTime;
        }

        public int getBdmId() {
            return bdmId;
        }

        public void setBdmId(int bdmId) {
            this.bdmId = bdmId;
        }

        public String getBdmCode() {
            return bdmCode;
        }

        public void setBdmCode(String bdmCode) {
            this.bdmCode = bdmCode;
        }

        public String getBdmName() {
            return bdmName;
        }

        public void setBdmName(String bdmName) {
            this.bdmName = bdmName;
        }

        public String getBdmType() {
            return bdmType;
        }

        public void setBdmType(String bdmType) {
            this.bdmType = bdmType;
        }

        public double getBdmLongitude() {
            return bdmLongitude;
        }

        public void setBdmLongitude(double bdmLongitude) {
            this.bdmLongitude = bdmLongitude;
        }

        public double getBdmLatitude() {
            return bdmLatitude;
        }

        public void setBdmLatitude(double bdmLatitude) {
            this.bdmLatitude = bdmLatitude;
        }

        public DepartmentBeanXX getDepartment() {
            return department;
        }

        public void setDepartment(DepartmentBeanXX department) {
            this.department = department;
        }

        public static class DepartmentBeanXX {
            /**
             * id : 147
             * text : 林业局
             * bdmLevel : null
             * createTime : 1497953847865
             * updateTime : 1497953847865
             * bdmId : 147
             * bdmCode : 04
             * bdmName : 林业局
             * bdmType : DD_FORESTRY
             * bdmLongitude : 116.089314
             * bdmLatitude : 24.272609
             * department : {"id":145,"text":"梅县区","bdmLevel":null,"createTime":1497953735041,"updateTime":1497953735041,"bdmId":145,"bdmCode":"02","bdmName":"梅县区","bdmType":"DD_PUBLIC_SECURITY","bdmLongitude":116.088894,"bdmLatitude":24.272185,"department":{"id":99999,"text":"梅州市","bdmLevel":1,"createTime":null,"updateTime":null,"bdmId":99999,"bdmCode":"01","bdmName":"梅州市","bdmType":null,"bdmLongitude":116.129223,"bdmLatitude":24.294547,"department":null}}
             */

            private int id;
            private String text;
            private Object bdmLevel;
            private long createTime;
            private long updateTime;
            private int bdmId;
            private String bdmCode;
            private String bdmName;
            private String bdmType;
            private double bdmLongitude;
            private double bdmLatitude;
            private DepartmentBeanX department;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public Object getBdmLevel() {
                return bdmLevel;
            }

            public void setBdmLevel(Object bdmLevel) {
                this.bdmLevel = bdmLevel;
            }

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }

            public long getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(long updateTime) {
                this.updateTime = updateTime;
            }

            public int getBdmId() {
                return bdmId;
            }

            public void setBdmId(int bdmId) {
                this.bdmId = bdmId;
            }

            public String getBdmCode() {
                return bdmCode;
            }

            public void setBdmCode(String bdmCode) {
                this.bdmCode = bdmCode;
            }

            public String getBdmName() {
                return bdmName;
            }

            public void setBdmName(String bdmName) {
                this.bdmName = bdmName;
            }

            public String getBdmType() {
                return bdmType;
            }

            public void setBdmType(String bdmType) {
                this.bdmType = bdmType;
            }

            public double getBdmLongitude() {
                return bdmLongitude;
            }

            public void setBdmLongitude(double bdmLongitude) {
                this.bdmLongitude = bdmLongitude;
            }

            public double getBdmLatitude() {
                return bdmLatitude;
            }

            public void setBdmLatitude(double bdmLatitude) {
                this.bdmLatitude = bdmLatitude;
            }

            public DepartmentBeanX getDepartment() {
                return department;
            }

            public void setDepartment(DepartmentBeanX department) {
                this.department = department;
            }

            public static class DepartmentBeanX {
                /**
                 * id : 145
                 * text : 梅县区
                 * bdmLevel : null
                 * createTime : 1497953735041
                 * updateTime : 1497953735041
                 * bdmId : 145
                 * bdmCode : 02
                 * bdmName : 梅县区
                 * bdmType : DD_PUBLIC_SECURITY
                 * bdmLongitude : 116.088894
                 * bdmLatitude : 24.272185
                 * department : {"id":99999,"text":"梅州市","bdmLevel":1,"createTime":null,"updateTime":null,"bdmId":99999,"bdmCode":"01","bdmName":"梅州市","bdmType":null,"bdmLongitude":116.129223,"bdmLatitude":24.294547,"department":null}
                 */

                private int id;
                private String text;
                private Object bdmLevel;
                private long createTime;
                private long updateTime;
                private int bdmId;
                private String bdmCode;
                private String bdmName;
                private String bdmType;
                private double bdmLongitude;
                private double bdmLatitude;
                private DepartmentBean department;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public Object getBdmLevel() {
                    return bdmLevel;
                }

                public void setBdmLevel(Object bdmLevel) {
                    this.bdmLevel = bdmLevel;
                }

                public long getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(long createTime) {
                    this.createTime = createTime;
                }

                public long getUpdateTime() {
                    return updateTime;
                }

                public void setUpdateTime(long updateTime) {
                    this.updateTime = updateTime;
                }

                public int getBdmId() {
                    return bdmId;
                }

                public void setBdmId(int bdmId) {
                    this.bdmId = bdmId;
                }

                public String getBdmCode() {
                    return bdmCode;
                }

                public void setBdmCode(String bdmCode) {
                    this.bdmCode = bdmCode;
                }

                public String getBdmName() {
                    return bdmName;
                }

                public void setBdmName(String bdmName) {
                    this.bdmName = bdmName;
                }

                public String getBdmType() {
                    return bdmType;
                }

                public void setBdmType(String bdmType) {
                    this.bdmType = bdmType;
                }

                public double getBdmLongitude() {
                    return bdmLongitude;
                }

                public void setBdmLongitude(double bdmLongitude) {
                    this.bdmLongitude = bdmLongitude;
                }

                public double getBdmLatitude() {
                    return bdmLatitude;
                }

                public void setBdmLatitude(double bdmLatitude) {
                    this.bdmLatitude = bdmLatitude;
                }

                public DepartmentBean getDepartment() {
                    return department;
                }

                public void setDepartment(DepartmentBean department) {
                    this.department = department;
                }

                public static class DepartmentBean {
                    /**
                     * id : 99999
                     * text : 梅州市
                     * bdmLevel : 1
                     * createTime : null
                     * updateTime : null
                     * bdmId : 99999
                     * bdmCode : 01
                     * bdmName : 梅州市
                     * bdmType : null
                     * bdmLongitude : 116.129223
                     * bdmLatitude : 24.294547
                     * department : null
                     */

                    private int id;
                    private String text;
                    private int bdmLevel;
                    private Object createTime;
                    private Object updateTime;
                    private int bdmId;
                    private String bdmCode;
                    private String bdmName;
                    private Object bdmType;
                    private double bdmLongitude;
                    private double bdmLatitude;
                    private Object department;

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getText() {
                        return text;
                    }

                    public void setText(String text) {
                        this.text = text;
                    }

                    public int getBdmLevel() {
                        return bdmLevel;
                    }

                    public void setBdmLevel(int bdmLevel) {
                        this.bdmLevel = bdmLevel;
                    }

                    public Object getCreateTime() {
                        return createTime;
                    }

                    public void setCreateTime(Object createTime) {
                        this.createTime = createTime;
                    }

                    public Object getUpdateTime() {
                        return updateTime;
                    }

                    public void setUpdateTime(Object updateTime) {
                        this.updateTime = updateTime;
                    }

                    public int getBdmId() {
                        return bdmId;
                    }

                    public void setBdmId(int bdmId) {
                        this.bdmId = bdmId;
                    }

                    public String getBdmCode() {
                        return bdmCode;
                    }

                    public void setBdmCode(String bdmCode) {
                        this.bdmCode = bdmCode;
                    }

                    public String getBdmName() {
                        return bdmName;
                    }

                    public void setBdmName(String bdmName) {
                        this.bdmName = bdmName;
                    }

                    public Object getBdmType() {
                        return bdmType;
                    }

                    public void setBdmType(Object bdmType) {
                        this.bdmType = bdmType;
                    }

                    public double getBdmLongitude() {
                        return bdmLongitude;
                    }

                    public void setBdmLongitude(double bdmLongitude) {
                        this.bdmLongitude = bdmLongitude;
                    }

                    public double getBdmLatitude() {
                        return bdmLatitude;
                    }

                    public void setBdmLatitude(double bdmLatitude) {
                        this.bdmLatitude = bdmLatitude;
                    }

                    public Object getDepartment() {
                        return department;
                    }

                    public void setDepartment(Object department) {
                        this.department = department;
                    }
                }
            }
        }
    }
}
