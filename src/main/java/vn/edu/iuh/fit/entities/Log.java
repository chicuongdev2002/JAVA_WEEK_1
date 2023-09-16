package vn.edu.iuh.fit.entities;

public class Log {
    private Role role;
    private Account acount;
    private boolean isGrant;
    private String note;

    public Log() {
    }

    public Log(Role role, Account acount, boolean isGrant, String note) {
        this.role = role;
        this.acount = acount;
        this.isGrant = isGrant;
        this.note = note;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Account getAcount() {
        return acount;
    }

    public void setAcount(Account acount) {
        this.acount = acount;
    }

    public boolean isGrant() {
        return isGrant;
    }

    public void setGrant(boolean grant) {
        isGrant = grant;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Log{" +
                "role=" + role +
                ", acount=" + acount +
                ", isGrant=" + isGrant +
                ", note='" + note + '\'' +
                '}';
    }
}
