package cse_2206.Smart_Marriage;

import java.sql.Date;

/**
 *
 * @author hocin
 */
public class marriage_data {

    int id;
    String name;
    String birth;
    String adress, email;
    String mstatus;
    String nid;

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getNid() {
        return nid;
    }

    public marriage_data(int id, String name, String birth, String adress, String email, String mstatus, String nid) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.adress = adress;
        this.email = email;
        this.mstatus = mstatus;
        this.nid = nid;
    }
    public void setMstatus(String mstatus) {
        this.mstatus = mstatus;
    }

    public String getMstatus() {
        return mstatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
