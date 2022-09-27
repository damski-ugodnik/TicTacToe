package model;

import provider.ICoordinateProvider;
import provider.impl.EasyAiCoordinateProvider;
import provider.impl.HardAiCoordinateProvider;
import provider.impl.HumanCoordinateProvider;
import provider.impl.MediumAiCoordinateProvider;

public enum PlayerType {
    USER(HumanCoordinateProvider.getInstance()),
    EASY(EasyAiCoordinateProvider.getInstance()),
    MEDIUM(MediumAiCoordinateProvider.getInstance()),
    HARD(HardAiCoordinateProvider.getInstance());

    private final ICoordinateProvider coordinateProvider;

    PlayerType(ICoordinateProvider coordinateProvider) {
        this.coordinateProvider = coordinateProvider;
    }

    public static ICoordinateProvider getProviderByTitle(String title) {
        for (PlayerType player : values()) {
            if (player.name().equalsIgnoreCase(title)) {
                return player.coordinateProvider;
            }
        }
        throw new IllegalArgumentException("No such player type");
    }

}
