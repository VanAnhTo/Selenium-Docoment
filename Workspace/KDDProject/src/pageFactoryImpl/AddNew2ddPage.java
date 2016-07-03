package pageFactoryImpl;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import domain.AddNew2ddDetails;
import domain.MaterialDetail;

public class AddNew2ddPage extends AddNewBase {
	WebDriver driver;

    public AddNew2ddPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void save2ddWith(AddNew2ddDetails new2ddDetails) throws InterruptedException
    {
    	this.clickCopporateCheckBox();
    	this.enterFileNumberFieldAs(new2ddDetails.getFileNumber());
    	this.enterSignWhereFieldAs(new2ddDetails.getSignWhere());
    	
    	for(MaterialDetail materialDetail : new2ddDetails.getMaterialDetailList()){
        	this.enterAmountMaterialFieldAs(materialDetail.getAmountMaterial());
        	this.enterContenMaterialFieldAs(materialDetail.getContenMaterial());
        	this.enterMaterialNameFieldAs(materialDetail.getMaterialName());
        	this.enterUnitMaterialFieldAs(materialDetail.getUnitMaterial());
        	this.enterRegistrationNumberFeildAs(materialDetail.getRegistrationNumber());
        	this.enterContentImportFieldFeildAs(materialDetail.getContentImportl());
        	this.enterContentrationFieldAs(materialDetail.getContentration());
        	this.enterQualityMaterialFieldAs(materialDetail.getQualityMateriall());
        	this.clickCommitedCheckbox();
        	this.focusOnProviderMaterialField();
        	this.chooseProviderMaterialCombobox();
        	this.focusManufacturalMaterialField();
        	this.choosemanufacturalMaterialCombobox();
        	this.clickAddMaterialButton();
        	Thread.sleep(3000);
    	}
    	this.clickSaveListMaterialButton();
    }
    
    
}
