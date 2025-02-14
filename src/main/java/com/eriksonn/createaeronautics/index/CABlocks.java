package com.eriksonn.createaeronautics.index;

import com.eriksonn.createaeronautics.CreateAeronautics;
import com.eriksonn.createaeronautics.blocks.LevititeCasingBlock;
import com.eriksonn.createaeronautics.blocks.airship_assembler.AirshipAssemblerBlock;
import com.eriksonn.createaeronautics.blocks.gyroscopic_propeller_bearing.GyroscopicBearingBlock;
import com.eriksonn.createaeronautics.blocks.propeller_bearing.PropellerBearingBlock;
import com.eriksonn.createaeronautics.blocks.redstone.modulating_redstone_link.ModulatingRedstoneLinkBlock;
import com.eriksonn.createaeronautics.blocks.stationary_potato_cannon.StationaryPotatoCannonBlock;
import com.eriksonn.createaeronautics.blocks.stirling_engine.StirlingEngineBlock;
import com.eriksonn.createaeronautics.blocks.torsion_spring.TorsionSpringBlock;
import com.eriksonn.createaeronautics.groups.CAItemGroups;

import com.eriksonn.createaeronautics.utils.BlockStateUtils;
import com.eriksonn.createaeronautics.utils.ModelUtils;
import com.simibubi.create.AllTags;
import com.simibubi.create.Create;
import com.simibubi.create.content.AllSections;
import com.simibubi.create.content.contraptions.base.CasingBlock;
import com.simibubi.create.foundation.data.BlockStateGen;
import com.simibubi.create.foundation.data.BuilderTransformers;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.data.SharedProperties;
import com.simibubi.create.repack.registrate.util.entry.BlockEntry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;

import static com.simibubi.create.foundation.data.ModelGen.customItemModel;

public class CABlocks {
    private static final CreateRegistrate REGISTRATE = CreateAeronautics.registrate()
            .itemGroup(() -> CAItemGroups.MAIN_GROUP);

    public static final BlockEntry<TorsionSpringBlock> TORSION_SPRING = REGISTRATE.block("torsion_spring", TorsionSpringBlock::new)
            .initialProperties(SharedProperties::stone)
            .properties(AbstractBlock.Properties::noOcclusion)
            .blockstate((ctx,prov) ->
                    BlockStateUtils.torsionSpringBlockstate(ctx, prov,
                            ModelUtils.existingModel(ctx, prov, "torsion_spring/block"), false
                    )
            )
            .tag(AllTags.AllBlockTags.SAFE_NBT.tag) //Dono what this tag means (contraption safe?).
            .item()
            .transform(customItemModel())
            .register();

    public static final BlockEntry<AirshipAssemblerBlock> AIRSHIP_ASSEMBLER = REGISTRATE.block("airship_assembler", AirshipAssemblerBlock::new)
            .initialProperties(SharedProperties::stone)
            .properties(AbstractBlock.Properties::noOcclusion)
            .blockstate((ctx,prov) ->
                    BlockStateGen.simpleBlock(ctx, prov,
                            ModelUtils.existingModelActive(ctx, prov, "airship_assembler/block")
                    )
            )
            .tag(AllTags.AllBlockTags.SAFE_NBT.tag) //Dono what this tag means (contraption safe?).
            .item()
            .transform(customItemModel())
            .register();

    public static final BlockEntry<PropellerBearingBlock> PROPELLER_BEARING = REGISTRATE.block("propeller_bearing", PropellerBearingBlock::new)
            .initialProperties(SharedProperties::stone)
            .properties(AbstractBlock.Properties::noOcclusion)
            .blockstate((ctx, prov) -> BlockStateUtils.facingBlockstate(ctx, prov, "block/propeller_bearing/block"))
            .tag(AllTags.AllBlockTags.SAFE_NBT.tag) //Dono what this tag means (contraption safe?).
            .item()
            .transform(customItemModel())
            .register();
    public static final BlockEntry<GyroscopicBearingBlock> GYROSCOPIC_PROPELLER_BEARING = REGISTRATE.block("gyroscopic_propeller_bearing",GyroscopicBearingBlock::new)
            .initialProperties(SharedProperties::stone)
            .properties(AbstractBlock.Properties::noOcclusion)
            .blockstate((ctx, prov) -> BlockStateUtils.facingBlockstate(ctx, prov, "block/gyroscopic_propeller_bearing/block"))
            .tag(AllTags.AllBlockTags.SAFE_NBT.tag) //Dono what this tag means (contraption safe?).
            .item()
            .transform(customItemModel())
            .register();
    public static final BlockEntry<StationaryPotatoCannonBlock> STATIONARY_POTATO_CANNON = REGISTRATE.block("stationary_potato_cannon", StationaryPotatoCannonBlock::new)
            .initialProperties(SharedProperties::stone)
            .blockstate(BlockStateUtils::directionalPoweredAxisBlockstate)
            .properties(AbstractBlock.Properties::noOcclusion)
            .tag(AllTags.AllBlockTags.SAFE_NBT.tag) //Dono what this tag means (contraption safe?).
            .item()
            .transform(customItemModel())
            .register();

    public static final BlockEntry<LevititeCasingBlock> LEVITITE_CASING = REGISTRATE.block("levitite_casing", LevititeCasingBlock::new)
            .transform(BuilderTransformers.casing(CASpriteShifts.LEVITITE_CASING)).properties((p) -> p.lightLevel(($) -> 12))
            .register();

    public static final BlockEntry<StirlingEngineBlock> STIRLING_ENGINE = REGISTRATE.block("stirling_engine", StirlingEngineBlock::new)
            .initialProperties(SharedProperties::stone)
            .properties(AbstractBlock.Properties::noOcclusion)
            .blockstate(BlockStateUtils::horizontalFacingLitBlockstate)
            .tag(AllTags.AllBlockTags.SAFE_NBT.tag) //Dono what this tag means (contraption safe?).
            .item().transform(customItemModel())
            .register();
    public static final BlockEntry<ModulatingRedstoneLinkBlock> MODULATING_REDSTONE_LINK = REGISTRATE.block("modulating_redstone_link", ModulatingRedstoneLinkBlock::new)
            .initialProperties(SharedProperties::stone)
            .properties(AbstractBlock.Properties::noOcclusion)
            .blockstate(BlockStateUtils::facingPoweredAxisBlockstate)
            .tag(AllTags.AllBlockTags.SAFE_NBT.tag) //Dono what this tag means (contraption safe?).
            .item().transform(customItemModel())
            .addLayer(() -> RenderType::translucent)
            .register();

    public static void register() {
        //CreateAeronautics.registrate().addToSection(TORSION_SPRING, AllSections.KINETICS);
    }

}
