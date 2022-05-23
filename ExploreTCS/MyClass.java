package ExploreTCS;

import java.util.*;
import java.io.*;

public class MyClass {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int rev = 0;
        int temp = n;
        while (temp != 0) {
            int ld = temp % 10;
            rev = rev * 10 + ld;
            temp = temp / 10;
        }
        System.out.println(rev);



//        RRT[] rr = new RRT[4];
//        for (int i = 0; i < rr.length; i++) {
//            int no = sc.nextInt();sc.nextLine();
//            String raised = sc.nextLine();
//            String assigned = sc.nextLine();
//            int priority = sc.nextInt();
//            String project = sc.nextLine();
//            rr[i] = new RRT(no,raised,assigned,priority,project);
//        }
//        String parm = sc.nextLine();
//
//        RRT res = getHighestPriorityTicket(rr,parm);
//        if (res==null){
//            System.out.println("No such Ticket");
//        }else {
//            System.out.println(res.getTicketNo()+"\n"+res.getRaisedBy()+"\n"+res.getAssignedTo());
//        }
    }

    public static RRT getHighestPriorityTicket(RRT[] rr,String par){
        Arrays.sort(rr,new Sort());
        for(RRT r : rr){
            if (r.getProject().equalsIgnoreCase(par))
                return r;
        }
        return null;
    }
}

class RRT{
    private int ticketNo;
    private String raisedBy;
    private String assignedTo;
    private int priority;
    private String project;

    public RRT(int ticketNo, String raisedBy, String assignedTo, int priority, String project) {
        this.ticketNo = ticketNo;
        this.raisedBy = raisedBy;
        this.assignedTo = assignedTo;
        this.priority = priority;
        this.project = project;
    }
    public int getTicketNo() {
        return ticketNo;
    }
    public String getRaisedBy() {
        return raisedBy;
    }
    public String getAssignedTo() {
        return assignedTo;
    }
    public int getPriority() {
        return priority;
    }
    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }
}

// Sorting Objects ,like we used to sort array sort(arr);
class Sort implements Comparator<RRT> {
    @Override
    public int compare(RRT o1, RRT o2) {
        return o1.getPriority()-o2.getPriority();
    }
}







class Cricketer{
    private int crickerterId;
    private String crickerterName;
    private int jercyNo;
    private String group;
    private String type;

    public Cricketer(int crickerterId, String crickerterName, int jercyNo, String group, String type) {
        this.crickerterId = crickerterId;
        this.crickerterName = crickerterName;
        this.jercyNo = jercyNo;
        this.group = group;
        this.type = type;
    }

    public int getCrickerterId() {
        return crickerterId;
    }
    public int getJercyNo() {
        return jercyNo;
    }
    public String getGroup() {
        return group;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}
class Institution{
    private int institutionId;
    private String institutionName;
    private String institutionLocation;
    private double rating;
    private boolean researchCentre;

    public Institution(int institutionId, String institutionName, String institutionLocation, double rating, boolean researchCentre) {
        this.institutionId = institutionId;
        this.institutionName = institutionName;
        this.institutionLocation = institutionLocation;
        this.rating = rating;
        this.researchCentre = researchCentre;
    }


    public String getInstitutionLocation() {
        return institutionLocation;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean isResearchCentre() {
        return researchCentre;
    }


}
class Flowers{
    private int flowerId;
    private String flowerName;
    private int price;
    private int rating;
    private String type;

    public Flowers(int flowerId, String flowerName, int price, int rating, String type) {
        this.flowerId = flowerId;
        this.flowerName = flowerName;
        this.price = price;
        this.rating = rating;
        this.type = type;
    }

    public int getFlowerId() {
        return flowerId;
    }

    public void setFlowerId(int flowerId) {
        this.flowerId = flowerId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
class GFG {

    static List<String> al = new ArrayList<>();
    static Integer k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        k = s.length() - 2;
        findsubsequences(s, "");
        int res = (al.size() % (int) (Math.pow(10, 9) + 7));
        System.out.println(res);
    }

    private static void findsubsequences(String s,
                                         String ans) {
        if (s.length() == 0) {
            if (ans.length() == k)
                al.add(ans);
            return;
        }
        findsubsequences(s.substring(1), ans + s.charAt(0));
        findsubsequences(s.substring(1), ans);
    }
}