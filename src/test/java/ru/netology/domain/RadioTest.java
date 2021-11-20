package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    //Общие данные:
    Radio radio = new Radio();

    boolean on = true;
    int minRadioStationNumber = 0;
    int maxRadioStationNumber = 9;
    int minVolume = 0;
    int maxVolume = 10;


    @Test   //Тест на выставление текущего номера радиостанции - позитивный, граничные значения
    void shouldCurrentRadioStationNumberPositiveBoundaryValues() {
        radio.setName("Panasonic-Z1-1");
        radio.setOn(on);
        radio.setMinRadioStationNumber(minRadioStationNumber);
        radio.setMaxRadioStationNumber(maxRadioStationNumber);

        radio.setCurrentRadioStationNumber(0);
        assertEquals(0, radio.getCurrentRadioStationNumber());

        radio.setCurrentRadioStationNumber(9);
        assertEquals(9, radio.getCurrentRadioStationNumber());
    }

    @Test   //Тест на выставление текущего номера радиостанции - негативный, граничные значения
    void shouldCurrentRadioStationNumberNegativeBoundaryValues() {
        radio.setName("Panasonic-Z1-1");
        radio.setOn(on);
        radio.setMinRadioStationNumber(minRadioStationNumber);
        radio.setMaxRadioStationNumber(maxRadioStationNumber);

        radio.setCurrentRadioStationNumber(-1);
        assertEquals(0, radio.getCurrentRadioStationNumber());

        radio.setCurrentRadioStationNumber(10);
        assertEquals(9, radio.getCurrentRadioStationNumber());
    }

    @Test   //Тест переключения текущего номера радиостанции на предыдущий - граничные значения
    void shouldPervRadioStationBoundaryValues() {
        radio.setName("Panasonic-Z1-2");
        radio.setOn(on);
        radio.setMinRadioStationNumber(minRadioStationNumber);
        radio.setMaxRadioStationNumber(maxRadioStationNumber);

        radio.setCurrentRadioStationNumber(0);
        radio.pervRadioStation();
        assertEquals(9, radio.getCurrentRadioStationNumber());

        radio.setCurrentRadioStationNumber(9);
        radio.pervRadioStation();
        assertEquals(8, radio.getCurrentRadioStationNumber());
    }

    @Test   //Тест переключения текущего номера радиостанции на следующий - граничные значения
    void shouldNextRadioStationBoundaryValues() {
        radio.setName("Panasonic-Z1-3");
        radio.setOn(on);
        radio.setMinRadioStationNumber(minRadioStationNumber);
        radio.setMaxRadioStationNumber(maxRadioStationNumber);

        radio.setCurrentRadioStationNumber(0);
        radio.nextRadioStation();
        assertEquals(1, radio.getCurrentRadioStationNumber());

        radio.setCurrentRadioStationNumber(9);
        radio.nextRadioStation();
        assertEquals(0, radio.getCurrentRadioStationNumber());
    }

    @Test   //Тест на выставление текущего уровня громкости - позитивный, граничные значения
    void shouldCurrentVolumePositiveBoundaryValues() {
        radio.setName("Panasonic-Z2-1");
        radio.setOn(on);
        radio.setMinVolume(minVolume);
        radio.setMaxVolume(maxVolume);

        radio.setCurrentVolume(0);
        assertEquals(0, radio.getCurrentVolume());

        radio.setCurrentVolume(10);
        assertEquals(10, radio.getCurrentVolume());
    }

    @Test   //Тест на выставление текущего уровня громкости - негативный, граничные значения
    void shouldCurrentVolumeNegativeBoundaryValues() {
        radio.setName("Panasonic-Z2-1");
        radio.setOn(on);
        radio.setMinVolume(minVolume);
        radio.setMaxVolume(maxVolume);

        radio.setCurrentVolume(-1);
        assertEquals(0, radio.getCurrentVolume());

        radio.setCurrentVolume(11);
        assertEquals(10, radio.getCurrentVolume());
    }

    @Test   //Тест на понижение текущего уровня громкости - граничные значения
    void shouldDecreaseVolumeBoundaryValues() {
        radio.setName("Panasonic-Z2-2");
        radio.setOn(on);
        radio.setMinVolume(minVolume);
        radio.setMaxVolume(maxVolume);

        radio.setCurrentVolume(0);
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());

        radio.setCurrentVolume(10);
        radio.decreaseVolume();
        assertEquals(9, radio.getCurrentVolume());
    }

    @Test   //Тест на повышение текущего уровня громкости - граничные значения
    void shouldIncreaseVolumeBoundaryValues() {
        radio.setName("Panasonic-Z2-3");
        radio.setOn(on);
        radio.setMinVolume(minVolume);
        radio.setMaxVolume(maxVolume);

        radio.setCurrentVolume(0);
        radio.increaseVolume();
        assertEquals(1, radio.getCurrentVolume());

        radio.setCurrentVolume(10);
        radio.increaseVolume();
        assertEquals(10, radio.getCurrentVolume());
    }
}