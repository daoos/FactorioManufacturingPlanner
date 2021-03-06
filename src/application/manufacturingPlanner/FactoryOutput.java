package application.manufacturingPlanner;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class FactoryOutput
{
	public enum ProductionRateUnit
	{
		Second, Minute, Hour, CompressedYellowBelt, CompressedRedBelt, CompressedBlueBelt
	}

	public Item item;
	private SimpleStringProperty name = new SimpleStringProperty();
	private ObjectProperty<Double> productionRate = new SimpleObjectProperty<Double>(1.0);
	private SimpleObjectProperty<ProductionRateUnit> productionRateUnit = new SimpleObjectProperty<ProductionRateUnit>(ProductionRateUnit.Minute);

	public FactoryOutput(Item item)
	{
		// TODO change this productName to an ObjectProperty containing the item!
		this.name.set(item.name);
		this.item = item;
	}

	public double getProductionRate()
	{
		return productionRate.get();
	}

	public double getProductionRatePerSecond()
	{
		double divisor = 0;

		switch (productionRateUnit.get()) {
			case Second:
				divisor = 1.0;
				break;
			case Minute:
				divisor = 60.0;
				break;
			case Hour:
				divisor = 60.0 * 60.0;
				break;
			case CompressedYellowBelt:
				divisor = 1.0 / 13.33;
				break;
			case CompressedRedBelt:
				divisor = 1.0 / 26.66;
				break;
			case CompressedBlueBelt:
				divisor = 1.0 / 40.0;
				break;
		}

		return productionRate.get() / divisor;
	}

	public String getName()
	{
		return name.get();
	}

	public ProductionRateUnit getProductionRateUnit()
	{
		return productionRateUnit.get();
	}

	public void setProductionRate(double newProductionRate)
	{
		productionRate.set(newProductionRate);
	}

	public ObjectProperty<Double> productionRateProperty()
	{
		return productionRate;
	}

	public void setProductionRateUnit(ProductionRateUnit newProductionRateUnit)
	{
		productionRateUnit.set(newProductionRateUnit);
	}

	public ObjectProperty<ProductionRateUnit> productionRateUnitProperty()
	{
		return productionRateUnit;
	}
}
