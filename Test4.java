public class Test4 {
    public static void main(String[] args) {
        Score score = new Score(10);
        System.out.println(score.getScore());
        System.out.println(score.hashCode());
        newTest(score);
        System.out.println("------- score 수정 --------");
        System.out.println(score.getScore());
    }

    public static Score newTest(Score score) {
        System.out.println(score.hashCode());
        score.setScore(5);
        return score;
    }
}

class Score {
    private int score;

    public Score(int score) {
        this.score = score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}
