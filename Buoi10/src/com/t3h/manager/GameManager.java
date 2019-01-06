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
        SoundManager.play("menu.wav");
        mapManager.readMap("mapGame1.txt");
        arrBoom = new ArrayList<>();
        player = new Player(200, 200);
        arrBoss = new ArrayList<>();
        initBoss();
    }

    private void initBoss() {
        if (arrBoss.size() > 2) {
            return;
        }
        arrBoss.add(new Boss(100, 100));
        arrBoss.add(new Boss(40, 510));
        arrBoss.add(new Boss(450, 300));
    }

    public void draw(Graphics2D g2d) {
        for (MapBoom map : mapManager.getArrMap()) {
            map.draw(g2d);
        }
        for (int i = arrBoom.size() - 1; i >= 0; i--) {
            boolean check = arrBoom.get(i).draw(g2d);
            if (check) {
                arrBoom.remove(i);
            }
        }
        for (Boss b : arrBoss) {
            b.draw(g2d);
        }
        player.draw(g2d);

    }

    public void movePlayer(int newOrient) {
        player.changeOrient(newOrient);
        player.move(mapManager.getArrMap());
    }

    public void playerFire() {
        player.fire(arrBoom);
    }

    public boolean AI() {
        for (int i = arrBoss.size() - 1; i >= 0; i--) {
            arrBoss.get(i).move(mapManager.getArrMap());
            boolean check = arrBoss.get(i).checkDie(arrBoom);
            if (check) {
                SoundManager.play("wahoo.wav");
                arrBoss.remove(i);
                initBoss();
            }
        }
        for (MapBoom map : mapManager.getArrMap()) {
            map.checkBoom(arrBoom);
        }
        return player.checkDie(arrBoom, arrBoss);
    }
}
