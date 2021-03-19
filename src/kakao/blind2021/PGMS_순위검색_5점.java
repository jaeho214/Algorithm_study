package kakao.blind2021;

import java.util.*;

public class PGMS_순위검색_5점 {
    public static void main(String[] args) {
        PGMS_순위검색_5점 pgms_순위검색5점 = new PGMS_순위검색_5점();
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        System.out.println(pgms_순위검색5점.solution(info, query));
    }

    public enum Language{
        JAVA("java"), PYTHON("python"), CPP("cpp"), ALL("-");
        String language;

        Language(String language) {
            this.language = language;
        }

        static Language of(String language){
            if(language.equals("java"))
                return JAVA;
            else if(language.equals("python"))
                return PYTHON;
            else if(language.equals("cpp"))
                return CPP;
            else
                return ALL;
        }
    }
    public enum Part{
        FRONT("frontend"), BACK("backend"), ALL("-");
        String part;

        Part(String part) {
            this.part = part;
        }

        static Part of(String part){
            if(part.equals("frontend"))
                return FRONT;
            else if(part.equals("backend"))
                return BACK;
            else
                return ALL;
        }
    }
    public enum Experience{
        JUNIOR("junior"), SENIOR("senior"), ALL("-");
        String experience;

        Experience(String experience) {
            this.experience = experience;
        }

        static Experience of(String experience){
            if(experience.equals("junior"))
                return JUNIOR;
            else if(experience.equals("senior"))
                return SENIOR;
            else
                return ALL;
        }
    }
    public enum Food{
        CHICKEN("chicken"), PIZZA("pizza"), ALL("-");
        String food;

        Food(String food) {
            this.food = food;
        }

        static Food of(String food){
            if(food.equals("chicken"))
                return CHICKEN;
            else if(food.equals("pizza"))
                return PIZZA;
            else
                return ALL;
        }
    }

    public static class Recruiter{
        Language lang;
        Part part;
        Experience experience;
        Food food;

        public Recruiter(Language lang, Part part, Experience experience, Food food) {
            this.lang = lang;
            this.part = part;
            this.experience = experience;
            this.food = food;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Recruiter)) return false;
            Recruiter recruiter = (Recruiter) o;

            boolean isSameExperience = false;
            boolean isSameLanguage = false;
            boolean isSamePart = false;
            boolean isSameFood = false;

            if(recruiter.experience == experience || recruiter.experience.equals(Experience.ALL))
                isSameExperience = true;
            if(recruiter.lang == lang || recruiter.lang.equals(Language.ALL))
                isSameLanguage = true;
            if(recruiter.part == part || recruiter.part.equals(Part.ALL))
                isSamePart = true;
            if(recruiter.food == food || recruiter.food.equals(Food.ALL))
                isSameFood = true;
            return isSameExperience && isSamePart && isSameLanguage && isSameFood;
        }

        @Override
        public int hashCode() {
            return Objects.hash(lang, part, experience, food);
        }
    }

    public int[] solution(String[] info, String[] query) {
        Map<Recruiter, List<Integer>> recruiterMap = new HashMap<>();

        for(String i : info){
            String[] s = i.split(" ");
            Recruiter recruiter = new Recruiter(Language.of(s[0]), Part.of(s[1]), Experience.of(s[2]), Food.of(s[3]));
            if(!recruiterMap.containsKey(recruiter)){
                recruiterMap.put(recruiter, new ArrayList<>());
            }
            recruiterMap.get(recruiter).add(Integer.parseInt(s[4].trim()));
        }

        for(Recruiter recruiter : recruiterMap.keySet()){
            List<Integer> scoreList = recruiterMap.get(recruiter);
            Collections.sort(scoreList);
            recruiterMap.put(recruiter, scoreList);
        }


        int[] answer = new int[query.length];
        int idx = 0;
        for(String q : query){
            String[] s = q.split(" and ");
            int cnt=0;
            String[] second = s[3].trim().split(" ");
            int score = Integer.parseInt(second[1]);
            for(Map.Entry<Recruiter, List<Integer>> entry : recruiterMap.entrySet()){
                if(entry.getKey().equals(new Recruiter(Language.of(s[0]), Part.of(s[1]), Experience.of(s[2]), Food.of(second[0])))){
                    int i = count(entry.getValue(), score);
                    cnt += entry.getValue().size()-i;
                }
            }
            answer[idx++] = cnt;
        }


        return answer;
    }

    private int count(List<Integer> value, int target) {

        int left = 0;
        int right = value.size();

        while(left < right){
            int mid = (left+right)/2;

            if(value.get(mid) >= target) right = mid;
            else left = mid+1;
        }

        return right;
    }
}
