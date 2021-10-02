package com.eduflex.eduflexbackend.service;

import com.eduflex.eduflexbackend.model.Hod;

import java.util.List;

public interface HodService {
    Hod addHod(Hod hod);

    Hod updateHod(Hod hod);

    void deleteHodByHodId(int hodId);

    List<Hod> getAllHodies();

    Hod getHodByHodId(int hodId);
}