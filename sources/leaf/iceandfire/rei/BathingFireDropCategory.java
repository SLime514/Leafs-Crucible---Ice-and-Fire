package leaf.iceandfire.rei;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1802;
import net.minecraft.class_2561;

@Environment(EnvType.CLIENT)
public class BathingFireDropCategory implements DisplayCategory<BathingFireDropDisplay> {
    public CategoryIdentifier<? extends BathingFireDropDisplay> getCategoryIdentifier() {
        return LeafsCrucibleREIPlugin.BATHING_FIRE_DROP;
    }

    public class_2561 getTitle() {
        return class_2561.method_43471("rei.category.leafs-crucible.bathing_fire_drop");
    }

    public Renderer getIcon() {
        return EntryStacks.of(class_1802.field_8183);
    }

    public List<Widget> setupDisplay(BathingFireDropDisplay display, Rectangle bounds) {
        Point startPoint = new Point(bounds.getCenterX() - 58, bounds.getCenterY() - 27);
        List<Widget> widgets = new ArrayList<>();
        widgets.add(Widgets.createRecipeBase(bounds));
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 18, startPoint.y)).entries(display.getFirstInput()).markInput());
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 62, startPoint.y)).entries(display.getSecondInput()).markInput());
        widgets.add(Widgets.createArrow(new Point(startPoint.x + 36, startPoint.y + 1)));
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 98, startPoint.y)).entries((Collection) display.getOutputEntries().get(0)).markOutput());
        if (display.getChance() < 1.0f) {
            widgets.add(Widgets.createLabel(new Point(startPoint.x + 98, startPoint.y + 20), class_2561.method_43469("rei.category.leafs-crucible.chance", new Object[]{String.format("%.1f%%", Float.valueOf(display.getChance() * 100.0f))})).noShadow().leftAligned().color(-12566464, -4473925));
        }
        return widgets;
    }

    public int getDisplayHeight() {
        return 55;
    }
}
