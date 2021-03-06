import java.util.Date;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		// Add your implementation here
		return students;
	}

	@Override
	public void setStudents(Student[] students) {
		// Add your implementation here
		if(students==null)
		{	
			throw new IllegalArgumentException();
		}
		else
		{
			int n = students.length;
			for(int i=0;i<n;i++)
			{
				this.students[i] = students[i];
			}
		}
	}

	@Override
	public Student getStudent(int index) {
		// Add your implementation here
		if(index < 0 || index > students.length){
			throw new IllegalArgumentException();
		}
		else{
			return students[index];
		}
	}

	@Override
	public void setStudent(Student student, int index) {
		// Add your implementation here
		if(students == null){
			throw new IllegalArgumentException();
		}
		else if(index < 0 || index > students.length){
			throw new IllegalArgumentException();
		}
		else{
			//students[index].setId(student.getId());
			//students[index].setAvgMark(student.getAvgMark());
			//students[index].setBirthDate(student.getBirthDate());
			//students[index].setFullName(student.getFullName());
			students[index]=student;
		}
	}

	@Override
	public void addFirst(Student student) {
		// Add your implementation here
		if(students == null){
			throw new IllegalArgumentException();
		}
		else{
			Student[] students1 = new Student[students.length+1];
			students1[0]=student;
			for(int i=0;i<students.length;i++){
				students1[i+1]=students[i];
			}
			students = new Student[students1.length];
			for(int i=0;i<students.length;i++){
				students[i]=students1[i];
			}
		}
	}

	@Override
	public void addLast(Student student) {
		// Add your implementation here
		if(students == null){
			throw new IllegalArgumentException();
		}
		else{
			Student[] students1 = new Student[students.length+1];
			students1[students1.length-1]=student;
			for(int i=0;i<students1.length-1;i++){
				students1[i]=students[i];
			}
			students = new Student[students1.length];
			for(int i=0;i<students.length;i++){
				students[i]=students1[i];
			}
		}
	}

	@Override
	public void add(Student student, int index) {
		// Add your implementation here
		if(students == null){
			throw new IllegalArgumentException();
		}
		else if(index < 0 || index > students.length){
			throw new IllegalArgumentException();
		}
		else{
			Student[] students1 = new Student[students.length+1];
			students1[index] = student;
			for(int i=0;i<index;i++){
				students1[i] = students[i];
			}
			for(int i=index;i<students.length;i++){
				students1[i+1] = students[i];
			}
			students = new Student[students1.length];
			for(int i=0;i<students.length;i++){
				students[i]=students1[i];
			}
		}
	}

	@Override
	public void remove(int index) {
		// Add your implementation here
		if(index < 0 || index > students.length){
			throw new IllegalArgumentException();
		}
		else{
			Student[] students1 = new Student[students.length-1];
			for(int i=0;i<index;i++){
				students1[i] = students[i];
			}
			for(int i=index+1;i<students.length;i++){
				students1[i-1] = students[i];
			}
			students = new Student[students1.length];
			for(int i=0;i<students.length;i++){
				students[i]=students1[i];
			}
		}
	}

	@Override
	public void remove(Student student) {
		// Add your implementation here
		if(student == null)
			throw new IllegalArgumentException();
		else{
			int i=0,k=0;
			for(i=0;i<students.length;i++)
			{
				if(students[i] == student)
				{
					break;
				}
				else
				{
					k++;
				}
			}
			if(k == students.length)
			{
				throw new IllegalArgumentException("Student not exist");
			}
			
			int l=0;
	        Student s[] = new Student[students.length-1];
			
			for(int j=0;j<i;j++)
			{
				s[l] = students[j];l++;
			}
			
			for(int j=i+1;j<students.length;j++)
			{
				s[l] = students[j];l++;
			}	
			students = null;		
			students = s;			
		}
	}

	@Override
	public void removeFromIndex(int index) {
		// Add your implementation here
		if(index < 0 || index >= students.length)
			throw new IllegalArgumentException();
		else
		{
			Student s[] = new Student[index+1];
			for(int i=0;i<=index;i++)
			{
				s[i] = students[i];
			}
            students = null;		
			students = s;
		}
	}

	@Override
	public void removeFromElement(Student student) {
		// Add your implementation here
		if(student == null)
			throw new IllegalArgumentException();
		else
		{
			int k=0;
			for(k=0;k<students.length;k++)
			{
				if(students[k] == student)
				{
					break;
				}
			}
			Student s[] = new Student[k+1];
			for(int i=0;i<=k;i++)
			{
				s[i] = students[i];
			}
            students = null;
			students = s;	
		}
	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
		if(index < 0 || index >= students.length)
			throw new IllegalArgumentException();
		else
		{
			Student s[] = new Student[students.length-index-1];
			int k=0;
			for(int i=index;i<students.length;i++)
			{
				s[k] = students[i]; k++;
			}		
            students = null;	
			students = s;	
		}
	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
		if(student == null)
			throw new IllegalArgumentException();
		else
		{
			int m=0;
			for(m=0;m<students.length;m++)
			{
				if(students[m] == student)
				{
					break;
				}
			}
			Student s[] = new Student[students.length-m-1];
			int k=0;
			for(int i=m;i<students.length;i++)
			{
				s[k] = students[i]; 
				k++;
			}			
            students = null;			
			students = s;			
		}
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
		for(int i=0;i<students.length;i++)
		{
			for(int j=0;j<students.length-i;j++)
			{
				if( students[j].compareTo(students[j+1]) > 0)
				{
						Student temp = students[j];
						students[j] = students[j+1];
						students[j+1] = temp;
				}
			}
		} 
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
		int j=0;
		if(date == null){
			throw new IllegalArgumentException();
		}
		else{	
			for(int i=0;i<students.length;i++){
				if(students[i].getBirthDate().before(date)){
					j++;
				}
			}
			int k=0;
			Student s[] = new Student[j];
			for(int i=0;i<students.length;i++){
				if(students[i].getBirthDate().before(date)){
					s[k] = students[i];
				}
			}
			return s;
		}
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
		if(firstDate == null || lastDate==null){
			throw new IllegalArgumentException();
		}
		else{
			int length=0;
			for(int i=0;i<students.length;i++)
			{
				if(students[i].getBirthDate().after(firstDate)  && students[i].getBirthDate().before(lastDate))
				{
					length++;
				}
			}
			int k=0;
			Student s[] = new Student[length];
			for(int i=0;i<students.length;i++){
				if(students[i].getBirthDate().after(firstDate)  && students[i].getBirthDate().before(lastDate))
				{
					s[k]=students[i];
					k++;
				}
			}
			return s;
		}
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		Date d1=new Date(date.getDate()+days);
			int c=0,c1=0;
			if(date==null)
				throw new IllegalArgumentException();
			for(int i=0;i<students.length;i++){
				if(students[i].getBirthDate()==date || students[i].getBirthDate()==d1 ){
					c++;
				}
			}
			Student[] s =  new Student[c];
			for(int i=0;i<students.length;i++){
				if(students[i].getBirthDate()==date || students[i].getBirthDate()==d1 ){
					s[c1]=students[i];
					c1++;
				}
			}
			return s;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		if(indexOfStudent==0)
			throw new IllegalArgumentException();
		Date d=new Date();
		long age=(d.getTime()/(1000 * 60 * 60 * 24*365))-(students[indexOfStudent].getBirthDate().getTime()/(1000 * 60 * 60 * 24*365));
		return (int)age;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		int cnt=0;
		for(int i=0;i<students.length;i++)
		{
			int age1=this.getCurrentAgeByDate(i);
			if(age1==age)
			{
				cnt++;
			}
		}
		Student[] s=new Student[cnt];
		cnt=0;
		for(int i=0;i<students.length;i++)
		{
			int age1=this.getCurrentAgeByDate(i);
			if(age1==age)
			{
				s[i]=students[i];
			}
		}
		return s;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		return null;
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
		return null;
	}
}
