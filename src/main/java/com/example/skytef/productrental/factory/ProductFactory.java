package com.example.skytef.productrental.factory;

import com.example.skytef.productrental.dto.ProductOrderDTO;
import com.example.skytef.productrental.model.ProductTypeEnum;

public class ProductFactory {
    public static ProductStrategy getFactory(ProductOrderDTO productOrderDTO) {
        ProductTypeEnum productType = productOrderDTO.getProductType();

        switch (productType) {
            case LAPTOP:
                return new LaptopsStrategy();
            case CAMERA:
                return new GamingConsoleStrategy();
            case PROJECTOR:
                return new OculusVrStrategy();
            case GAMING_CONSOLE:
                return new ProjectorsStrategy();
            case OCULOS_VR:
                return new CamerasStrategy();
            default:
                return null;
        }
    }
}
