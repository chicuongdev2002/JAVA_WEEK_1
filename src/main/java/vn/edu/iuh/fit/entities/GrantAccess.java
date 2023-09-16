package vn.edu.iuh.fit.entities;


public class GrantAccess {
private Role role;
private Account account;
private boolean inGrant;
private String note;

    public GrantAccess() {
    }

    public GrantAccess(Role role, Account account, boolean inGrant, String note) {
        this.role = role;
        this.account = account;
        this.inGrant = inGrant;
        this.note = note;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public boolean isInGrant() {
        return inGrant;
    }

    public void setInGrant(boolean inGrant) {
        this.inGrant = inGrant;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "GrantAccess{" +
                "role=" + role +
                ", account=" + account +
                ", inGrant=" + inGrant +
                ", note='" + note + '\'' +
                '}';
    }
}
