package BaiTap3;

import java.util.ArrayList;
import java.util.List;

public class HocSinhService {
    //Them
    private List<HocSinh> hocSinhList = new ArrayList<>();
    //fake data 3 phan tu
    public  HocSinhService(){
        hocSinhList.add(
                new HocSinh(1,"Chu","Ngân", 19,2)
        );
        hocSinhList.add(
                new HocSinh(2,"Chu","Huyền", 19,2)
        );
        hocSinhList.add(
                new HocSinh(3,"Chu","Nga", 19,2)
        );
    }
    //Chuc nang them
    public  void add(HocSinh hocSinh){
        //Check cap do : cap 1, cap 2, cap 3
        if (hocSinh.getGradeLevel() < 1 || hocSinh.getGradeLevel() > 3){
            //nem ngoai le
            throw new IllegalArgumentException("Cấp học của học sinh chỉ từ 1 đến 3");
        }else{
            hocSinhList.add(hocSinh);
        }
    }
    //Tao class validate trong, chua ky tu dac biet
    public  boolean validate(String inputSearch){
        if (inputSearch.trim().isEmpty()){
            //check trong
            throw new NullPointerException("LastName khong duoc trong");
        }else {
            if(!inputSearch.matches(".*[a-zA-Z0-9].*")){
                throw new IllegalArgumentException("LastName khong chua ky tu dac biet");
            }
        }
        return true;
    }
    //Tim kiem
    public int searchByLastName(String lastName){
        int count = 0;
        if (validate(lastName)){
            for (HocSinh hocSinh: hocSinhList ) {
                String lastNameHocSinh = hocSinh.getLastName();
                if (lastNameHocSinh.equalsIgnoreCase(lastName)){
                    count++;
                }
            }
            //Neu tim thay ten dem thi count ++, ngc lai thi nem ra ngoai le (khong trong list)
            if (count == 0){
                throw new ArrayIndexOutOfBoundsException("Khong co ten dem trong ds");
            }else{
                  return  count;
            }
        }
        return 0;
    }
    public List<HocSinh> getAll(){
        return  hocSinhList;
    }



}
