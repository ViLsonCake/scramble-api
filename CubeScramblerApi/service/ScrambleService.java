package com.project.CubeScramblerApi.CubeScramblerApi.service;

import com.project.CubeScramblerApi.CubeScramblerApi.exception.CubeIsNotValidException;
import com.project.CubeScramblerApi.CubeScramblerApi.validate.CubeValidate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ScrambleService {

    public String getScramble(String cube) throws CubeIsNotValidException {
        if (!CubeValidate.isCubeValid(cube))
            throw new CubeIsNotValidException("Cube is not valid");

        return getCurrentCubeScramble(cube);
    }

    public String getCurrentCubeScramble(String cube) {

        String[] defaultMoves = null, defaultSuffix = null, extendMoves = null, defaultPrefix = null;
        Map<String, Integer> cubeScrambleLength = new HashMap<>();
        {
            // Add values
            cubeScrambleLength.put("2x2", 9);
            cubeScrambleLength.put("3x3", 20);
            cubeScrambleLength.put("4x4", 40);
            cubeScrambleLength.put("5x5", 60);
            cubeScrambleLength.put("6x6", 80);
            cubeScrambleLength.put("7x7", 100);
        }

        if (cube.equalsIgnoreCase("2x2")) {
            defaultMoves = new String[] {"U", "F", "R"};
            defaultSuffix = new String[] {"", "'", "2"};

        } else if (cube.equalsIgnoreCase("3x3")) {
            defaultMoves = new String[] {"U", "D", "F", "B", "R", "L"};
            defaultSuffix = new String[] {"", "'", "2"};
        } else if (cube.equalsIgnoreCase("4x4")) {
            defaultMoves = new String[] {"U", "D", "F", "B", "R", "L", "Uw", "Fw", "Rw", "Lw"};
            defaultSuffix = new String[] {"", "'", "2"};
        } else if (cube.equalsIgnoreCase("5x5")) {
            defaultMoves = new String[] {"U", "D", "F", "B", "R", "L", "Uw", "Dw", "Fw", "Bw", "Rw", "Lw"};
            defaultSuffix = new String[] {"", "'", "2"};
        } else if (cube.equalsIgnoreCase("6x6")) {
            defaultMoves = new String[] {"U", "D", "F", "B", "R", "L", "Uw", "Dw", "Fw", "Bw", "Rw", "Lw", "3Uw", "3Fw", "3Rw"};
            defaultSuffix = new String[] {"", "'", "2"};
        } else if (cube.equalsIgnoreCase("7x7")) {
            defaultMoves = new String[] {"U", "D", "F", "B", "R", "L", "Uw", "Dw", "Fw", "Bw", "Rw", "Lw", "3Uw", "3Dw", "3Fw", "3Bw", "3Rw", "3Lw"};
            defaultSuffix = new String[] {"", "'", "2"};
        }

        return generateScramble(defaultMoves, defaultSuffix, cubeScrambleLength.get(cube));

    }

    public String generateScramble(String[] defaultMoves, String[] defaultSuffix, int scrambleLength) {

        List<String> scrambleList = new ArrayList<>();

        for (int i = 0; i < scrambleLength; i++) {
            String randomMove = choice(defaultMoves);
            String randomSuffix = choice(defaultSuffix);

            // If move is not first
            if (i > 0) {
                while (scrambleList.get(i - 1).contains(randomMove)) {
                    randomMove = choice(defaultMoves);
                }
            }
            // Add move to list
            scrambleList.add(String.format("%s%s ",  randomMove, randomSuffix));
        }

        StringBuilder output = new StringBuilder();

        // Convert list to string
        for (String move : scrambleList) {
            output.append(move);
        }

        return output.toString();
    }

    public String choice(String[] sequence) {
        if (sequence == null)
            return "";

        return sequence[new Random().nextInt(sequence.length)]; // Return random element
    }
}
