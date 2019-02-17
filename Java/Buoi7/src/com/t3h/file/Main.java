package com.t3h.file;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        FileManager manager = new FileManager();
//        manager.management();
//        manager.readAllFile(new File("C:\\"));
//        manager.write("Hello world\n");
//        manager.read();
        String link = "https://vnno-vn-6-tf-mcloud-bf-s7-mv-zmp3.zadn.vn/DU_htVF8zdY/3aab2173bf3756690f26/6491f49ffada13844acb/480/Neu-Ta-Nguoc-Loi.mp4?authen=exp=1544531114~acl=/DU_htVF8zdY/*~hmac=1eb724819ea9594b704571c73c7dd929";
        manager.downloadFile(link, "Neu ta nguo lou.mp4");
    }
}
