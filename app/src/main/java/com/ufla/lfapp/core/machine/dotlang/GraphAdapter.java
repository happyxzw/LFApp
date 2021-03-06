package com.ufla.lfapp.core.machine.dotlang;

import com.ufla.lfapp.core.machine.MachineType;
import com.ufla.lfapp.core.machine.State;
import com.ufla.lfapp.utils.MyPoint;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by carlos on 15/07/17.
 */

public class GraphAdapter implements Serializable {

    public Set<State> stateSet;
    public List<Edge> edgeList;
    public Map<State, MyPoint> stateMyPointMap;
    public Set<State> stateFinals;
    public State startState;
    public DotLanguage dotLanguage;

    public GraphAdapter() {
        stateSet = new TreeSet<>();
        edgeList = new ArrayList<>();
        stateFinals = new TreeSet<>();
        stateMyPointMap = new HashMap<>();
    }

}
