package com.t3h.manager;

import com.t3h.model.Boom;
import com.t3h.model.Boss;
import com.t3h.model.MapBoom;
import com.t3h.model.Player;

import java.awt.*;
import java.util.ArrayList;

public class GameManager {
    private ArrayList<Boss> arrBoss;
    private Player player;
    private ArrayList<Boom> arrBoom;
    private MapManager mapManager = new MapManager();

    public void initGame() {
        mapManager.readMap("mapGame1.txt");
        arrBoom = new ArrayList<>();
        player = new Player(200, 200);
        arrBoss = new ArrayList<>();
        initBoss();
    }

    private void initBoss() {
        arrBoss.add(new Boss(100, 100));
        arrBoss.add(new Boss(200, 400));
        arrBoss.add(new Boss(500, 200));
    }

    public void draw(Graphics2D g2d) {
        for (MapBoom map: mapManager.getArrMap()) {
            map.draw(g2d);
        }
        for (int i = arrBoom.size() - 1; i >= 0; i--) {
            boolean check = arrBoom.get(i).draw(g2d);
            if (check){
                arrBoom.remove(i);
            }
        }
        for (Boss b : arrBoss) {
            b.draw(g2d);
        }
        player.draw(g2d);

    }

    public void movePlayer(int newOrient){
        player.changeOrient(newOrient);
        player.move();
    }

    public void playerFire(){
        player.fire(arrBoom);
    }

    public void AI() {
        for (int i = 0; i < arrBoss.size(); i++) {
            arrBoss.get(i).move();
        }
    }
}
