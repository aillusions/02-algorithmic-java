package com.zalizniak.medium.levenshtein_distance;

/**
 * Levenshtein distance: minimum number of single-character edits:
 * <p>
 * - insertions
 * - deletions
 * - substitutions
 */
public interface LevenshteinDistance {

    int getDistance(String a, String b);
}
