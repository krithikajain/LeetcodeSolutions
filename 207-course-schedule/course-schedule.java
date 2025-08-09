class Solution {
    //create map to store the course and prequisite
    private Map<Integer, List<Integer>> courses = new HashMap<>();

    //create a set to keep track of the current course whose prereqs are being checked
    private Set<Integer> visiting = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //populate the map by filling in the courses
        for(int i=0; i<numCourses; i++){
            courses.put(i, new ArrayList<>());
        }

        //populate the prereqs for the courses
        for(int[] p : prerequisites){
            courses.get(p[0]).add(p[1]);
        }

        //traverse through the courses to fulfill the prereq
        for(int c=0; c<numCourses; c++){
            //check whether courses is empty
            if(!dfs(c)){
                return false;
            }
        }
        return true;
    }
    //helper function to check whether the course can be completed
    private boolean dfs(int crs){
        //check if a course is in the set 
        if(visiting.contains(crs)){
            return false; // cycle
        }
        //check if a course has any prereqs left
        if(courses.get(crs).isEmpty()){
            return true; //no prereqs/ all are satisfied
        }
        
        //mark it as visited
        visiting.add(crs);

        //traverse through it's prereqs
        for(int pre : courses.get(crs)){
            if(!dfs(pre)){ //for every preq of the course run the dfs for that
                return false;
            }
        }
        visiting.remove(crs); //we finished checking for this course so we remove that from the path 
        courses.put(crs, new ArrayList<>()); //clear the prereqs for this course
        return true;
    }
}

//CLARIFICATION
//directed graph preq=[a,b] --- b -> a
//if cycles present - not valid
//return true even for one valid order
//multiple orders a,b,c or b,a,c
//num_courses = 1, [0]

