package com.alkemy.ong.domain.slides;

import java.util.List;

public interface SlideService {
    List<SlideModel> getAll();
    SlideModel getDetails(int id);
}
