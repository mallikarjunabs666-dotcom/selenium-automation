package Day2APIAutomationDifferentwaysofcreatingpostrequestbody;

public class PojoMainclass {


    String firstname;
    String lastname;
    int totalprice;
    boolean depositpaid;

    Pojofordatebookings bookingdates;




    String additionalneeds;

//    for assigning and retriving data we use setters and getters method

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }


    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }


    public boolean getdepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }


    public Pojofordatebookings getBookingdates()
    {
        return bookingdates;
    }

    public void setBookingdates(Pojofordatebookings bookingdates) {
        this.bookingdates = bookingdates;
    }




    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }
}










