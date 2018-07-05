package ua.ahreshchik.votingsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ua.ahreshchik.votingsystem.model.Meal;
import ua.ahreshchik.votingsystem.repository.MealRepository;
import ua.ahreshchik.votingsystem.service.MealService;
import ua.ahreshchik.votingsystem.util.exception.NotFoundException;

import java.util.List;

@Service
public class MealServiceImpl implements MealService {


    MealRepository mealRepository;

    @Autowired
    public MealServiceImpl(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    @Override
    public Meal create(Meal meal) {
        Assert.notNull(meal, "meal must not be null");
        return mealRepository.save(meal);
    }

    @Override
    public Meal get(int id) throws NotFoundException {
        return mealRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Meal meal) {
        Assert.notNull(meal, "meal must not be null");
        mealRepository.save(meal);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        mealRepository.delete(id);

    }

    @Override
    public List<Meal> getAll() {
        return mealRepository.findAll();
    }
}
