package jettabyte.sjabsmpt;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import java.util.Random;

public class Event implements Listener {

    //월드 전체 패널티 기능 (킬작 방지)
    int darp;

    //사망 이벤트
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        //플레이어가 죽는다면 플레이어를 p 변수에 저장하고 랜덤 숫자 drp를 추첨
        Player p = (Player) e.getEntity();
        Random random = new Random();
        int drp;
        drp = random.nextInt(99);
        //랜덤 드롭
        System.out.println(ChatColor.GREEN + "플레이어 사망 확인");
        if (drp == 0) {
            //drp가 0이라면 네더라이트 드롭
            p.getWorld().dropItemNaturally(p.getLocation(), new ItemStack(Material.NETHERITE_INGOT));
            e.setDeathMessage(ChatColor.GOLD + "누군가 죽었습니다.\n하지만..! 네더라이트를 떨구고 죽었습니다.");
            darp =+ 1;
            System.out.println(ChatColor.GREEN + "플레이어 사망 확인 => 아이템 드롭 완료(특별)");
        } else {
            //drp가 0이 아니라면 다이아몬드 드롭
            p.getWorld().dropItemNaturally(p.getLocation(), new ItemStack(Material.DIAMOND));
            e.setDeathMessage(ChatColor.RED + "누군가 죽었습니다.");
            darp =+ 1;
            System.out.println(ChatColor.GREEN + "플레이어 사망 확인 => 아이템 드롭 완료");
        }
        //인벤 세이브 X 레벨 세이브 O 설정후 log
        e.setKeepInventory(false);
        e.setKeepLevel(true);
        System.out.println(ChatColor.GREEN + "플레이어 사망 확인 => 아이템 드롭 완료 => 작업 종료");
    }

}
