/*
 * Copyright (c) 2021, Jake Downie, All Rights Reserved
 */

package com.basicrpg.items;

/**
 * World Item class, list of default items for use elsewhere.
 *
 * @author Jake Downie
 * @author jwd2488
 * @version 0.1
 * @since 0.1
 */
public class WorldItems {

    private static final int BASHING = 1;
    private static final int CUTTING = 2;

    public static com.basicrpg.items.Item apple = new com.basicrpg.items.Item("Apple", "A red fruit.", 1, com.basicrpg.items.Item::AppleEffect);
    public static com.basicrpg.items.Weapon rusty_sword = new com.basicrpg.items.Weapon(5, CUTTING, "Rusty Sword", "This sword has seen better days.", 4);
    public static com.basicrpg.items.Clothing rusty_chainmail = new com.basicrpg.items.Clothing("Rusty Chainmail", "This chainmail armor has seen better days", 3, 5, 2);
    public static com.basicrpg.items.Clothing boring_boots = new com.basicrpg.items.Clothing("Boring Boots", "These boring boots have seen better days", 3, 2, 3);
    public static com.basicrpg.items.Clothing ugly_helm = new com.basicrpg.items.Clothing("Ugly Helm", "This ugly helm has seen better days", 3, 3, 1);


}
