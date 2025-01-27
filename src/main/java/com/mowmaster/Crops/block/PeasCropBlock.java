package com.mowmaster.Crops.block;

import com.mowmaster.Crops.DefferredRegistryCropItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PeasCropBlock extends CropBlock {
    //3 stages for beanstalk + 4 stages for pea growth, resets to stage 4 on harvest???
    public static final int MAX_AGE = 7;
    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 7);


    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]
            {
                    Block.box((double)0.0F, (double)0.0F, (double)0.0F, (double)16.0F, (double)2.0F, (double)16.0F),
                    Block.box((double)0.0F, (double)0.0F, (double)0.0F, (double)16.0F, (double)4.0F, (double)16.0F),
                    Block.box((double)0.0F, (double)0.0F, (double)0.0F, (double)16.0F, (double)6.0F, (double)16.0F),
                    Block.box((double)0.0F, (double)0.0F, (double)0.0F, (double)16.0F, (double)8.0F, (double)16.0F),
                    Block.box((double)0.0F, (double)0.0F, (double)0.0F, (double)16.0F, (double)10.0F, (double)16.0F),
                    Block.box((double)0.0F, (double)0.0F, (double)0.0F, (double)16.0F, (double)12.0F, (double)16.0F),
                    Block.box((double)0.0F, (double)0.0F, (double)0.0F, (double)16.0F, (double)14.0F, (double)16.0F),
                    Block.box((double)0.0F, (double)0.0F, (double)0.0F, (double)16.0F, (double)16.0F, (double)16.0F)
            };

    public PeasCropBlock(Properties p_52247_) {
        super(p_52247_);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE_BY_AGE[state.getValue(AGE)];
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return DefferredRegistryCropItems.PEA_SEEDS;
    }

    @Override
    protected IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}
