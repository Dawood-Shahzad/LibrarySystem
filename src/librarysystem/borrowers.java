package librarysystem;


public class borrowers {
   private String borrowersname;
    private String borrowedamount;
    private String borrowersemail;
   private double date;

    public borrowers(String borrowersname, String borrowedamount, String email, double date) {
        this.borrowersname = borrowersname;
        this.borrowedamount = borrowedamount;
        this.borrowersemail = email;
        this.date = date;
    }
     public String toString() {
        return borrowersname+","+ borrowedamount+","+ borrowersemail+","+ date+",";
    }
    
    public String getBorrowersname() {
        return borrowersname;
    }

    public String getBookamount() {
        return borrowedamount;
    }

    public String getBorrowersmail() {
        return borrowersemail;
    }

    public double getDate() {
        return date;
    }

    public void setBorrowersname(String borrowersname) {
        this.borrowersname = borrowersname;
    }

    public void setBookamount(String bookamount) {
        this.borrowedamount = bookamount;
    }

    public void setBorrowersemail(String email) {
        this.borrowersemail = borrowersemail;
    }

    public void setDate(double date) {
        this.date = date;
    }

    Object getBorrowersemail() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
   
}
