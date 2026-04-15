import { useEffect, useState } from "react";
import { useNavigate, useParams, Link } from "react-router-dom";
import axiosInstance from "../api/axiosInstance";
import { useSelector } from "react-redux";

function BoardDetailPage() {
  const { id } = useParams();
  const navigate = useNavigate();

  const [board, setBoard] = useState(null);

  const { isAuthenticated, username } = useSelector((state) => state.user);

  useEffect(() => {
    getBoard();
  }, [id]);

  const getBoard = async () => {
    try {
      const res = await axiosInstance.get(`/api/boards/${id}`);
      setBoard(res.data);
    } catch (error) {
      console.error("게시글 상세 조회 실패:", error);
    }
  };

  const handleDelete = async () => {
    const check = window.confirm("정말 삭제하시겠습니까?");
    if (!check) return;

    try {
      await axiosInstance.delete(`/api/boards/${id}`);
      alert("삭제 완료");
      navigate("/boards");
    } catch (error) {
      console.error("게시글 삭제 실패:", error);
      alert("삭제 실패");
    }
  };

  if (!board) {
    return <p>로딩 중...</p>;
  }

  return (
    <div>
      <h2>게시글 상세</h2>
      <p>
        <strong>제목:</strong> {board.title}
      </p>
      <p>
        <strong>작성자:</strong> {board.writer}
      </p>
      <p>
        <strong>내용:</strong>
      </p>
      <div>{board.content}</div>

      <br />

      {isAuthenticated && username === board.writer && (
        <>
          <Link to={`/boards/edit/${board.id}`}>수정</Link>
          {" | "}
          <button onClick={handleDelete}>삭제</button>
          {" | "}
        </>
      )}

      <Link to="/boards">목록</Link>
    </div>
  );
}

export default BoardDetailPage;
