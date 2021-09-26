package com.eduflex.eduflexbackend.service;

import java.util.List;

import com.eduflex.eduflexbackend.model.Hod;

public interface HodService {
    Hod addHod(Hod hod);
    Hod updateHod(Hod hod);
    void deleteHodByHodId(int hodId);
    List<Hod> getAllHodies();
    Hod getHodByHodId(int hodId);
}