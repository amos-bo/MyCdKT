package com.ktcd.malc.kt_ma_lc.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/11/7.
 */

public class MapResourcePointInfoMore implements Serializable{
    /**
     * type : place
     * countBasicDataNumVoList : [{"basicDataId":"06E677B24FD84FAA8A964A2328091D6E","basicDataCode":"shelter","basicDataName":"避难场所","informationPointList":[{"permissionControlCondition":null,"createTime":1509953675000,"createUser":{"permissionControlCondition":null,"createTime":null,"createUser":null,"updateTime":null,"updateUser":null,"areaCode":null,"departmentCode":null,"departmentType":null,"id":"990BBF33C198478DA41560E8129A40DF","account":null,"state":null,"deleted":null,"locked":null,"name":null,"nickname":null,"phoneNumber":null,"email":null,"password":null,"onLine":null,"lastLoginDate":null,"roles":null,"department":null},"updateTime":null,"updateUser":null,"areaCode":".1.","departmentCode":".1.","departmentType":null,"id":"BCC31B32BC26430790382BB2D37742AB","title":"避难场所名称","longitude":116.112422,"latitude":24.263565,"category":"place","subclass":"shelter","contactName":"向赵臣","contactTelephone":"15882069645","contactMobilePhone":"15882069645","responsibleName":null,"responsibleTelephone":null,"responsibleMobilePhone":null}]}]
     */

    private String type;
    private List<CountBasicDataNumVoListBean> countBasicDataNumVoList;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<CountBasicDataNumVoListBean> getCountBasicDataNumVoList() {
        return countBasicDataNumVoList;
    }

    public void setCountBasicDataNumVoList(List<CountBasicDataNumVoListBean> countBasicDataNumVoList) {
        this.countBasicDataNumVoList = countBasicDataNumVoList;
    }

    public static class CountBasicDataNumVoListBean implements Serializable{
        /**
         * basicDataId : 06E677B24FD84FAA8A964A2328091D6E
         * basicDataCode : shelter
         * basicDataName : 避难场所
         * informationPointList : [{"permissionControlCondition":null,"createTime":1509953675000,"createUser":{"permissionControlCondition":null,"createTime":null,"createUser":null,"updateTime":null,"updateUser":null,"areaCode":null,"departmentCode":null,"departmentType":null,"id":"990BBF33C198478DA41560E8129A40DF","account":null,"state":null,"deleted":null,"locked":null,"name":null,"nickname":null,"phoneNumber":null,"email":null,"password":null,"onLine":null,"lastLoginDate":null,"roles":null,"department":null},"updateTime":null,"updateUser":null,"areaCode":".1.","departmentCode":".1.","departmentType":null,"id":"BCC31B32BC26430790382BB2D37742AB","title":"避难场所名称","longitude":116.112422,"latitude":24.263565,"category":"place","subclass":"shelter","contactName":"向赵臣","contactTelephone":"15882069645","contactMobilePhone":"15882069645","responsibleName":null,"responsibleTelephone":null,"responsibleMobilePhone":null}]
         */

        private String basicDataId;
        private String basicDataCode;
        private String basicDataName;
        private List<InformationPointListBean> informationPointList;

        public String getBasicDataId() {
            return basicDataId;
        }

        public void setBasicDataId(String basicDataId) {
            this.basicDataId = basicDataId;
        }

        public String getBasicDataCode() {
            return basicDataCode;
        }

        public void setBasicDataCode(String basicDataCode) {
            this.basicDataCode = basicDataCode;
        }

        public String getBasicDataName() {
            return basicDataName;
        }

        public void setBasicDataName(String basicDataName) {
            this.basicDataName = basicDataName;
        }

        public List<InformationPointListBean> getInformationPointList() {
            return informationPointList;
        }

        public void setInformationPointList(List<InformationPointListBean> informationPointList) {
            this.informationPointList = informationPointList;
        }

        public static class InformationPointListBean implements Serializable{
            /**
             * permissionControlCondition : null
             * createTime : 1509953675000
             * createUser : {"permissionControlCondition":null,"createTime":null,"createUser":null,"updateTime":null,"updateUser":null,"areaCode":null,"departmentCode":null,"departmentType":null,"id":"990BBF33C198478DA41560E8129A40DF","account":null,"state":null,"deleted":null,"locked":null,"name":null,"nickname":null,"phoneNumber":null,"email":null,"password":null,"onLine":null,"lastLoginDate":null,"roles":null,"department":null}
             * updateTime : null
             * updateUser : null
             * areaCode : .1.
             * departmentCode : .1.
             * departmentType : null
             * id : BCC31B32BC26430790382BB2D37742AB
             * title : 避难场所名称
             * longitude : 116.112422
             * latitude : 24.263565
             * category : place
             * subclass : shelter
             * contactName : 向赵臣
             * contactTelephone : 15882069645
             * contactMobilePhone : 15882069645
             * responsibleName : null
             * responsibleTelephone : null
             * responsibleMobilePhone : null
             */

            private Object permissionControlCondition;
            private long createTime;
            private CreateUserBean createUser;
            private Object updateTime;
            private Object updateUser;
            private String areaCode;
            private String departmentCode;
            private Object departmentType;
            private String id;
            private String title;
            private double longitude;
            private double latitude;
            private String category;
            private String subclass;
            private String contactName;
            private String contactTelephone;
            private String contactMobilePhone;
            private Object responsibleName;
            private Object responsibleTelephone;
            private Object responsibleMobilePhone;

            public Object getPermissionControlCondition() {
                return permissionControlCondition;
            }

            public void setPermissionControlCondition(Object permissionControlCondition) {
                this.permissionControlCondition = permissionControlCondition;
            }

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }

            public CreateUserBean getCreateUser() {
                return createUser;
            }

            public void setCreateUser(CreateUserBean createUser) {
                this.createUser = createUser;
            }

            public Object getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(Object updateTime) {
                this.updateTime = updateTime;
            }

            public Object getUpdateUser() {
                return updateUser;
            }

            public void setUpdateUser(Object updateUser) {
                this.updateUser = updateUser;
            }

            public String getAreaCode() {
                return areaCode;
            }

            public void setAreaCode(String areaCode) {
                this.areaCode = areaCode;
            }

            public String getDepartmentCode() {
                return departmentCode;
            }

            public void setDepartmentCode(String departmentCode) {
                this.departmentCode = departmentCode;
            }

            public Object getDepartmentType() {
                return departmentType;
            }

            public void setDepartmentType(Object departmentType) {
                this.departmentType = departmentType;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public double getLongitude() {
                return longitude;
            }

            public void setLongitude(double longitude) {
                this.longitude = longitude;
            }

            public double getLatitude() {
                return latitude;
            }

            public void setLatitude(double latitude) {
                this.latitude = latitude;
            }

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public String getSubclass() {
                return subclass;
            }

            public void setSubclass(String subclass) {
                this.subclass = subclass;
            }

            public String getContactName() {
                return contactName;
            }

            public void setContactName(String contactName) {
                this.contactName = contactName;
            }

            public String getContactTelephone() {
                return contactTelephone;
            }

            public void setContactTelephone(String contactTelephone) {
                this.contactTelephone = contactTelephone;
            }

            public String getContactMobilePhone() {
                return contactMobilePhone;
            }

            public void setContactMobilePhone(String contactMobilePhone) {
                this.contactMobilePhone = contactMobilePhone;
            }

            public Object getResponsibleName() {
                return responsibleName;
            }

            public void setResponsibleName(Object responsibleName) {
                this.responsibleName = responsibleName;
            }

            public Object getResponsibleTelephone() {
                return responsibleTelephone;
            }

            public void setResponsibleTelephone(Object responsibleTelephone) {
                this.responsibleTelephone = responsibleTelephone;
            }

            public Object getResponsibleMobilePhone() {
                return responsibleMobilePhone;
            }

            public void setResponsibleMobilePhone(Object responsibleMobilePhone) {
                this.responsibleMobilePhone = responsibleMobilePhone;
            }

            public static class CreateUserBean implements Serializable{
                /**
                 * permissionControlCondition : null
                 * createTime : null
                 * createUser : null
                 * updateTime : null
                 * updateUser : null
                 * areaCode : null
                 * departmentCode : null
                 * departmentType : null
                 * id : 990BBF33C198478DA41560E8129A40DF
                 * account : null
                 * state : null
                 * deleted : null
                 * locked : null
                 * name : null
                 * nickname : null
                 * phoneNumber : null
                 * email : null
                 * password : null
                 * onLine : null
                 * lastLoginDate : null
                 * roles : null
                 * department : null
                 */

                private Object permissionControlCondition;
                private Object createTime;
                private Object createUser;
                private Object updateTime;
                private Object updateUser;
                private Object areaCode;
                private Object departmentCode;
                private Object departmentType;
                private String id;
                private Object account;
                private Object state;
                private Object deleted;
                private Object locked;
                private Object name;
                private Object nickname;
                private Object phoneNumber;
                private Object email;
                private Object password;
                private Object onLine;
                private Object lastLoginDate;
                private Object roles;
                private Object department;

                public Object getPermissionControlCondition() {
                    return permissionControlCondition;
                }

                public void setPermissionControlCondition(Object permissionControlCondition) {
                    this.permissionControlCondition = permissionControlCondition;
                }

                public Object getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(Object createTime) {
                    this.createTime = createTime;
                }

                public Object getCreateUser() {
                    return createUser;
                }

                public void setCreateUser(Object createUser) {
                    this.createUser = createUser;
                }

                public Object getUpdateTime() {
                    return updateTime;
                }

                public void setUpdateTime(Object updateTime) {
                    this.updateTime = updateTime;
                }

                public Object getUpdateUser() {
                    return updateUser;
                }

                public void setUpdateUser(Object updateUser) {
                    this.updateUser = updateUser;
                }

                public Object getAreaCode() {
                    return areaCode;
                }

                public void setAreaCode(Object areaCode) {
                    this.areaCode = areaCode;
                }

                public Object getDepartmentCode() {
                    return departmentCode;
                }

                public void setDepartmentCode(Object departmentCode) {
                    this.departmentCode = departmentCode;
                }

                public Object getDepartmentType() {
                    return departmentType;
                }

                public void setDepartmentType(Object departmentType) {
                    this.departmentType = departmentType;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public Object getAccount() {
                    return account;
                }

                public void setAccount(Object account) {
                    this.account = account;
                }

                public Object getState() {
                    return state;
                }

                public void setState(Object state) {
                    this.state = state;
                }

                public Object getDeleted() {
                    return deleted;
                }

                public void setDeleted(Object deleted) {
                    this.deleted = deleted;
                }

                public Object getLocked() {
                    return locked;
                }

                public void setLocked(Object locked) {
                    this.locked = locked;
                }

                public Object getName() {
                    return name;
                }

                public void setName(Object name) {
                    this.name = name;
                }

                public Object getNickname() {
                    return nickname;
                }

                public void setNickname(Object nickname) {
                    this.nickname = nickname;
                }

                public Object getPhoneNumber() {
                    return phoneNumber;
                }

                public void setPhoneNumber(Object phoneNumber) {
                    this.phoneNumber = phoneNumber;
                }

                public Object getEmail() {
                    return email;
                }

                public void setEmail(Object email) {
                    this.email = email;
                }

                public Object getPassword() {
                    return password;
                }

                public void setPassword(Object password) {
                    this.password = password;
                }

                public Object getOnLine() {
                    return onLine;
                }

                public void setOnLine(Object onLine) {
                    this.onLine = onLine;
                }

                public Object getLastLoginDate() {
                    return lastLoginDate;
                }

                public void setLastLoginDate(Object lastLoginDate) {
                    this.lastLoginDate = lastLoginDate;
                }

                public Object getRoles() {
                    return roles;
                }

                public void setRoles(Object roles) {
                    this.roles = roles;
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
