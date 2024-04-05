import BaiTap3.HocSinh;
import BaiTap3.HocSinhService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class HocSinhServiceTest {
    //Tao doi tuong HocSinhService
    //List
    private HocSinhService hocSinhService = new HocSinhService();
    private List<HocSinh> hocSinhList = hocSinhService.getAll();
    @Test
    //Them thanh cong voi cap tai bien 1
    public  void addSuccesLevel1(){
        //Ket qua mong muon
        int exp = 4;//Hoc sinh fake co 3 HS, them 1 thanh 4
        HocSinh hocSinhMoi = new HocSinh(4,"Chu","Ngân", 19,1);
        hocSinhService.add(hocSinhMoi);
        //Ket qua thuc te
        int act = hocSinhList.size();//kiem tra lai kich thuoc cua danh sach la bao nhieu???
        Assertions.assertEquals(exp,act);
    }
    //Them thanh cong voi cap tai bien 3
    @Test
    public  void addSuccesLevel3(){
        //Ket qua mong muon
        int exp = 4;//Hoc sinh fake co 3 HS, them 1 thanh 4
        HocSinh hocSinhMoi = new HocSinh(4,"Chu","Ngân", 19,3);
        hocSinhService.add(hocSinhMoi);
        //Ket qua thuc te
        int act = hocSinhList.size();//kiem tra lai kich thuoc cua danh sach la bao nhieu???
        Assertions.assertEquals(exp,act);
    }
    //Phuong phap tai bien
    //TH ngoai bien 1
    @Test
    //Them doi voi hoc sinh có cấp học là -1
    public  void themCapHocKhongHopLe(){
        HocSinh hocSinhSaiCap = new HocSinh(5,"Chu","Ngân", 19,-1);
        Assertions.assertThrows(IllegalArgumentException.class, ()-> hocSinhService.add(hocSinhSaiCap));
    }
    //TH ngoai bien 3
    @Test
    //Them doi voi hoc sinh có cấp học là -1
    public  void themCapHocKhongHopLe2(){
        HocSinh hocSinhSaiCap = new HocSinh(5,"Chu","Ngân", 19,4);
        Assertions.assertThrows(IllegalArgumentException.class, ()-> hocSinhService.add(hocSinhSaiCap));
    }
    //Can bien ve nha viet
    //Tim kiem hoc sinh voi ten chua ky tu dac biet
    @Test
    public  void searchLastNameChuaKyTuDacBiet(){
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,()-> hocSinhService.searchByLastName("Ngân@"));
    }
    //Tim kiem trong
    @Test
    public  void searchLastNameNULL(){
        Assertions.assertThrows(NullPointerException.class,()-> hocSinhService.searchByLastName(""));
    }
    //Tim hoc sinh ten la Phuc
    @Test
    public  void searchLastNameKhongCo(){
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,()-> hocSinhService.searchByLastName("Phuc"));
    }

}
