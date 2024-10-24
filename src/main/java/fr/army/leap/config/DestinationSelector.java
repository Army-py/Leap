package fr.army.leap.config;

import fr.army.leap.LeapPlugin;
import fr.army.leap.menu.button.ButtonItem;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class DestinationSelector {

    public static final String SELECTOR_IDENTIFIER = "leap_destination_selector";

    private final ButtonItem buttonItem;
    private final int slot;

    public DestinationSelector(ButtonItem buttonItem, int slot){
        this.buttonItem = buttonItem;
        this.slot = slot;
    }

    public ItemStack getButtonItem(){
        return buttonItem
                .setIdentifier(SELECTOR_IDENTIFIER)
                .build();
    }

    public int getSlot() {
        return slot;
    }

    public static boolean isDestinationSelector(ItemStack item){
        final ItemMeta itemMeta = item.getItemMeta();
        if (itemMeta == null) return false;

        return itemMeta.getPersistentDataContainer().has(
                new NamespacedKey(LeapPlugin.getPlugin(), "identifier"),
                PersistentDataType.STRING
        );
    }
}
