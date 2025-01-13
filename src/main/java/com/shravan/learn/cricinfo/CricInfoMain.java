package com.shravan.learn.cricinfo;

// Cricinfo -> ScorecardService, MatchService
// addMatch, updateMatchStatus
// createScorecard, updateScore, addInnings

// MatchService - map Matches
// addMatch, getMatch, updateMatchStatus

// Match -> id, title, venue, Teams, matchDateTime (LocalDateTime), MatchStatus, Scorecard
// Team -> name, Players
// Player -> name, role
// MatchStatus -> SCHEDULED, IN_PROGRESS, COMPLETED, ABANDONED

// ScorecardService -> map Scorecard, scorecardCounter
// createScorecard(match), getScorecard(), updateScore(scorecardId, teamId, score)
// addInnings(scorecardId, Innings)

// Scorecard -> Match, map teamScores (teamId -> score), Innings (size 2)
// Innings -> batting Team, bowling Team, Overs
// Over -> overNumber, Balls
// Ball -> ballNumber, bowler Player, batsman Player, result
public class CricInfoMain {
    public static void main(String[] args) {

    }
}
