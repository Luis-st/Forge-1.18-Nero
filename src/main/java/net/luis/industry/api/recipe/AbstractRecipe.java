package net.luis.industry.api.recipe;

import java.util.ArrayList;
import java.util.List;

import net.luis.industry.api.recipe.item.ResultItemStack;
import net.luis.industry.api.util.ItemStackList;
import net.luis.industry.api.util.VarArgs;
import net.minecraft.item.ItemStack;

public abstract class AbstractRecipe<T extends IModRecipe> implements IModRecipe {
	
	protected final List<ItemStack> recipeItems;
	protected final List<ResultItemStack> resultItems;
	protected final int progressTime;
	protected final int id;
	protected final IModRecipeHelper<T> recipeHelper;
	
	protected AbstractRecipe(VarArgs<ItemStack> recipeItems, VarArgs<ResultItemStack> reslutItems, int progressTime, IModRecipeHelper<T> recipeHelper, int id) {
		this.requireSize(recipeItems, this.getRecipeItemMaxCount());
		this.requireSize(reslutItems, this.getResultItemMaxCount());
		this.recipeItems = recipeItems.asList();
		this.resultItems = reslutItems.asList();
		this.progressTime = progressTime;
		this.id = id;
		this.recipeHelper = recipeHelper;
	}
	
	@Override
	public int getId() {
		return this.id;
	}
	
	@Override
	public IModRecipeHelper<T> getRecipeHelper() {
		return this.recipeHelper;
	}
	
	@Override
	public List<ItemStack> getRecipeItems() {
		return this.recipeItems;
	}

	@Override
	public List<ResultItemStack> getAllResultItems() {
		return this.resultItems;
	}

	@Override
	public List<ItemStack> getResultItems() {

		List<ItemStack> itemsToDrop = new ArrayList<ItemStack>();

		for (ResultItemStack resultItem : this.getAllResultItems()) {
			if (resultItem.isResult()) {
				itemsToDrop.add(resultItem.getItemStack());
			}
		}

		return itemsToDrop;

	}
	
	@Override
	public int getProgressTime() {
		return this.progressTime;
	}
	
	@Override
	public boolean canDrop(ItemStackList inventory) {
		
		int containedItems = 0;
		
		for (ItemStack toCheck : inventory) {
			if (this.containsItemStack(toCheck, false)) {
				containedItems++;
			}
		}
		
		return containedItems >= this.getRecipeItems().size();
	}
	
	@Override
	public boolean containsItemStack(ItemStack toCheck, boolean ignoreTags) {
		
		for (ItemStack itemStack : this.recipeItems) {
			if (this.equalsItemStack(itemStack, toCheck, ignoreTags)) {
				return true;
			}
		}
		
		return false;
		
	}
	
	@Override
	public boolean equalsItemStack(ItemStack itemStack, ItemStack toCheck, boolean ignoreTags) {
		
		if (itemStack.getItem() == toCheck.getItem()) {
			return toCheck.getCount() >= itemStack.getCount() || ignoreTags;
		}
		
		return false;
	}
	
	@Override
	public boolean equalsResultItemStack(ResultItemStack resultStack, ResultItemStack toCheck, boolean ignoreTags) {
		return resultStack.equals(resultStack, ignoreTags, true);
	}
	
	@Override
	public boolean equalsId(IModRecipe toCheck) {
		return this.equalsId(toCheck.getId());
	}

	@Override
	public boolean equalsId(int id) {
		return this.getId() == id;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (!(obj instanceof IModRecipe)) {
			return false;
		} else {
			
			IModRecipe recipe = (IModRecipe) obj;
			int equalRecipeItems = 0;
			int equalResultItems = 0;
			
			if (this.recipeItems.size() == recipe.getRecipeItems().size() && this.resultItems.size() == recipe.getAllResultItems().size()) {
				
				for (int i = 0; i < this.recipeItems.size(); i++) {
					
					ItemStack thisStack = this.recipeItems.get(i);
					ItemStack milestoneStack = recipe.getRecipeItems().get(i);
					
					if (this.equalsItemStack(thisStack, milestoneStack, false)) {
						equalRecipeItems++;
					}
				}
				
				for (int i = 0; i < this.resultItems.size(); i++) {
					
					ResultItemStack thisStack = this.resultItems.get(i);
					ResultItemStack recipeRecultStack = recipe.getAllResultItems().get(i);
					
					if (this.equalsResultItemStack(thisStack, recipeRecultStack, false)) {
						equalResultItems++;
					}
				}
			}
			
			return equalRecipeItems >= this.recipeItems.size() && equalResultItems >= this.resultItems.size();
			
		}
	}
	
	private final void requireSize(VarArgs<?> toCheck, int size) {

		if (toCheck.size() > size) {
			throw new IllegalArgumentException("The VarArgs<?> is longer than " + size);
		}
	}
	
}